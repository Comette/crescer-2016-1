'use strict'


function CavaleiroCadastroView() {
    $("#txtDtNascimento").datepicker({
        format: 'dd/MM/yyyy'
    });
}

CavaleiroCadastroView.prototype.adicionarCampoGolpe = function () {
    $('#frmNovoCavaleiro ul[id=novosGolpes]').attr('style', 'list-style-type: none')
        .append($('<li>')
            .append($('<input>').attr('name', 'golpe').attr('style', 'margin-top: 10px').attr('type', 'text').attr('placeholder', 'Ex: Trovão Aurora').addClass('form-control'))
        )
}

CavaleiroCadastroView.prototype.adicionarCampoImagem = function () {
    $('#frmNovoCavaleiro ul[id=novasImagens]').attr('style', 'list-style-type: none')
        .append($('<li>')
            .append($('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: goo.gl/UXQbW9').attr('style', 'margin-top: 10px').addClass('form-control'))
            .append($('<label>').text('É tumbnail? ')
                .append($('<input>').attr('type', 'checkbox').attr('name', 'isThumb'))
            )
        )
}

CavaleiroCadastroView.prototype.converteFormParaCavaleiro = function (form) {    
    var formData = new FormData(form[0]);

    var data = $('#txtDtNascimento').datepicker('getDate');
    
    var novasImagens = [];
    $('#novasImagens li').each(function(i) {
        novasImagens.push({
            Id:0,
            Url: $(this).find('input[name=urlImagem]').val(),
            IsThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function(i) {
        novosGolpes.push({
            Id: 0,
            Nome: $(this).find('input[name=golpe]').val()
            }           
        );
    });
    return {
        Id: formData.get('id'),
        Nome: formData.get('nome'),
        TipoSanguineo: formData.get('tipoSanguineo'),
        DataNascimento: data.toISOString(),
        AlturaCm: parseFloat(formData.get('alturaMetros')) * 100,
        PesoLb: Math.round((parseFloat(formData.get('pesoKg')) * 2.20462262) * 100) / 100,
        Signo: formData.get('signo'),
        LocalNascimento: {
            Id: 0,
            Texto: formData.get('localNascimento')
        },
        LocalTreinamento: {
            Ide: 0,
            Texto: formData.get('localTreinamento')
        },
        Golpes: novosGolpes,
        Imagens: novasImagens
    }
}
