'use strict'


function CavaleiroCadastroView() {
    $("#txtDtNascimento").datepicker({
        dateFormat: 'dd/mm/yy'
    });
    this.formCadastro = $('#frmNovoCavaleiro');
}

CavaleiroCadastroView.prototype.adicionarCampoGolpe = function () {
    $('#frmNovoCavaleiro ul[id=novosGolpes]').attr('style', 'list-style-type: none')
        .append($('<li>') 
            .append($('<input>').attr('name', 'IdGolpe').attr('style', 'display: none').attr('type', 'number'))
            .append($('<input>').attr('name', 'golpe').attr('style', 'margin-top: 10px').attr('type', 'text').attr('placeholder', 'Ex: Trovão Aurora').addClass('form-control'))
        )
}

CavaleiroCadastroView.prototype.adicionarCampoImagem = function () {
    $('#frmNovoCavaleiro ul[id=novasImagens]').attr('style', 'list-style-type: none')
        .append($('<li>')
            .append($('<input>').attr('name', 'IdImagem').attr('style', 'display: none').attr('type', 'number'))
            .append($('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: goo.gl/UXQbW9').attr('style', 'margin-top: 10px').addClass('form-control'))
            .append($('<label>').text('É tumbnail? ')
                .append($('<input>').attr('type', 'checkbox').attr('name', 'isThumb'))
            )
        )
}

CavaleiroCadastroView.prototype.converteFormParaCavaleiro = function (form) {    
    var formData = new FormData(form[0]);

    var data = $('#txtDtNascimento').datepicker('getDate');
    var dataPronta = data.toISOString();
    debugger;
    var novasImagens = [];
    $('#novasImagens li').each(function(i) {
        novasImagens.push({
            Id: $(this).find('input[name=IdImagem]').val() || 0,
            Url: $(this).find('input[name=urlImagem]').val(),
            IsThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function(i) {
        novosGolpes.push({
            Id: $(this).find('input[name=IdGolpe]').val() || 0,
            Nome: $(this).find('input[name=golpe]').val()
            }           
        );
    });
    return {
        Id: formData.get('IdCavaleiro') || 0,
        Nome: formData.get('nome'),
        TipoSanguineo: formData.get('tipoSanguineo'),
        DataNascimento: dataPronta,        
        AlturaCm: parseFloat(formData.get('alturaMetros')) * 100,
        PesoLb: Math.round((parseFloat(formData.get('pesoKg')) * 2.20462262) * 100) / 100,
        Signo: formData.get('signo'),
        LocalNascimento: {
            Id: formData.get('IdLocalNascimento') || 0,
            Texto: formData.get('localNascimento')
        },
        LocalTreinamento: {
            Id: formData.get('IdLocalTreinamento') || 0,
            Texto: formData.get('localTreinamento')
        },
        Golpes: novosGolpes,
        Imagens: novasImagens
    }
}

CavaleiroCadastroView.prototype.converteCavaleiroParaForm = function (data) {
    var self = data.self;
    var cavaleiro = data.cavaleiro;
    var formData = new FormData(self.formCadastro[0]);

    self.formCadastro.find('input[name=IdCavaleiro]').val(cavaleiro.Id);
    self.formCadastro.find('input[name=nome]').val(cavaleiro.Nome);
    self.formCadastro.find('input[name=alturaMetros]').val((cavaleiro.AlturaCm / 100).toString());
    self.formCadastro.find('input[name=pesoKg]').val((Math.round((cavaleiro.PesoLb / 2.20462262) * 100) / 100).toString());
    self.formCadastro.find('input[name=IdLocalNascimento]').val(cavaleiro.LocalNascimento.Id);
    self.formCadastro.find('input[name=localNascimento]').val(cavaleiro.LocalNascimento.Texto);
    self.formCadastro.find('input[name=IdLocalTreinamento]').val(cavaleiro.LocalTreinamento.Id);
    self.formCadastro.find('input[name=localTreinamento]').val(cavaleiro.LocalTreinamento.Texto);
    self.formCadastro.find('select[name=tipoSanguineo]').prop('selectedIndex', cavaleiro.TipoSanguineo);    
    self.formCadastro.find('select[name=signo]').prop('selectedIndex', cavaleiro.Signo);

    if (cavaleiro.Golpes.length > 0) {
        cavaleiro.Golpes.forEach(function (golpe) {
            self.adicionarCampoGolpe();
            self.formCadastro.find('input[name=IdGolpe]').val(golpe.Id);
            self.formCadastro.find('input[name=golpe]').val(golpe.Nome);
        });
    }
    if (cavaleiro.Imagens.length > 0) {
        cavaleiro.Imagens.forEach(function (img) {
            self.adicionarCampoImagem();
            self.formCadastro.find('input[name=IdImagem]').val(img.Id);
            self.formCadastro.find('input[name=urlImagem]').val(img.Url);
            self.formCadastro.find('input[name=isThumb]').prop('checked', img.IsThumb);
        });
    }
    var data = new Date(cavaleiro.DataNascimento);
    $('#txtDtNascimento').datepicker('setDate', data);
    
}

CavaleiroCadastroView.prototype.limpaFormulario = function () {
    $('#frmNovoCavaleiro').hide();
    $('#frmNovoCavaleiro')[0].reset();
    $('#frmNovoCavaleiro ul[id=novasImagens]').empty();
    $('#frmNovoCavaleiro ul[id=novosGolpes]').empty();
}
