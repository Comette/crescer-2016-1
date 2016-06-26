'use strict';

var cavaleirosListados = [];
var cadastroView = new CavaleiroCadastroView();

function CavaleiroIndexView(options) {
    options = options || {};
    this.errorToast = options.errorToast;
    this.successToast = options.successToast;
    this.cavaleirosUi = options.cavaleirosUi;
    this.cavaleiros = new Cavaleiros({
        urlGet: options.urlCavaleiroGet,
        urlGetById: options.urlCavaleiroGetById,
        urlPost: options.urlCavaleiroPost,
        urlDelete: options.urlCavaleiroDelete,
        urlPut: options.urlCavaleiroPut
    });
};

CavaleiroIndexView.prototype.render = function () {
    var self = this;
    // 1 - Carregar lista de cavaleiros na tela
    cavaleirosListados = [];
    this.cavaleiros.todos()
        .then(
            function onSuccess(res) {
                res.data.forEach(function (cava) {
                    self.cavaleirosUi.append(
                        self.addCavaleiroNaTabela(cava)
                    );
                    cavaleirosListados.push(cava.Id);                    
                });
            },
            function onError(res) {
                self.errorToast.show(res.status + ' - ' + res.statusText);
            }
        );
};

CavaleiroIndexView.prototype.excluirCavaleiroNoServidor = function (e) {
    var self = e.data.self;
    self.cavaleiros.excluir(e.data.id)
        .done(function (res) {
            self.successToast.show('Excluído com sucesso!');
            self.atualizaCavaleirosListados(self);
        });
};

CavaleiroIndexView.prototype.adicionarCavaleiroNoServidor = function (e) {
    var self = e.self;
    self.cavaleiros.inserir(e.cavaleiro)
        .done(function () {
            self.successToast.show('Incluído com sucesso!');
        });
};

CavaleiroIndexView.prototype.editarCavaleiroNoServidor = function (e) {
    var cavaleiro = e.cavaleiro
    var self = e.self;
    self.cavaleiros.editar(cavaleiro)
        .done(function (res) {
            self.successToast.show('Cavaleiro atualizado com sucesso!');
            self.atualizaCavaleirosListados(self);
        });   
};

CavaleiroIndexView.prototype.verificaNovosCavaleiros = function (elem) {
    var qtdNovoCavaleiros = 0;
    var self = elem;
    $.get(self.cavaleiros.urlGet).done(
        function (res) {
            res.data.forEach(function (cava) {
                if ($.inArray(cava.Id, cavaleirosListados) === -1) {
                    self.cavaleirosUi.append(
                        self.addCavaleiroNaTabela(cava)
                    );
                    cavaleirosListados.push(cava.Id);
                    qtdNovoCavaleiros++;
                }
            });            
        });
    if (qtdNovoCavaleiros > 0) {
        self.exibeNotificationNovosCavaleiros(qtdNovoCavaleiros);
    }
};

CavaleiroIndexView.prototype.exibeNotificationNovosCavaleiros = function (qtd) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var options = {
                body: qtd + ' novos cavaleiros foram adicionados!',
                icon: 'https://d30y9cdsu7xlg0.cloudfront.net/png/18397-200.png'
            }
            new Notification('', options);
        }
    });
}

CavaleiroIndexView.prototype.addCavaleiroNaTabela = function (cavaleiro) {
    var thumbnailPadrao = { Url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg', IsThumb: true };
    var ImagemTemp;
    cavaleiro.Imagens.forEach(function (img) {
        if (img.IsThumb === true) {
            ImagemTemp = img;
            return false;
        }
    })
    var Imagem = ImagemTemp ? ImagemTemp : thumbnailPadrao;

    return $('<tr>')
        .append($('<td>')
            .append($('<img>').attr('src', Imagem.Url).attr('style', 'width: 100px; height: 70px;'))            
        )
        .append($('<td>').attr('style', 'vertical-align: middle')
            .append($('<span>').attr('style', 'font-size: 24px').text(cavaleiro.Nome))
        )
        .append($('<td>') 
        .append($('<div>').addClass('btn-group-vertical').attr('role', 'group').attr('aria-label', '...')
            .append(
                $('<button>').addClass('btn btn-warning')
                    .click(function () {
                        $('#btnNovoCadastro').hide();
                        $('#frmNovoCavaleiro').show();
                        cadastroView.converteCavaleiroParaForm({ cavaleiro: cavaleiro, self: cadastroView });
                    })
                    .text('Editar')
            )
            .append(
                $('<button>').addClass('btn btn-danger')
                    .on('click', { id: cavaleiro.Id, self: this }, this.excluirCavaleiroNoServidor)
                    .text('Excluir')
        )));
}

CavaleiroIndexView.prototype.atualizaCavaleirosListados =  function(self){
    self.cavaleirosUi.empty();
    self.render();
}