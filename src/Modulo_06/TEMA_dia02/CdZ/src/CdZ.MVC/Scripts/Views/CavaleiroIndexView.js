'use strict';

var cavaleirosListados = [];

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
    this.cavaleiros.todos()
        .then(
            function onSuccess(res) {
                res.data.forEach(function (cava) {
                    self.cavaleirosUi.append(
                        self.criarHtmlCavaleiro(cava)
                    );
                    cavaleirosListados.push(cava.Id);
                });
            },
            function onError(res) {
                self.errorToast.show(res.status + ' - ' + res.statusText);
            }
        );
};

CavaleiroIndexView.prototype.criarHtmlCavaleiro = function (cava) {
    var thumbnailPadrao = { Url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg', IsThumb: true };
    var ImagemTemp;
    cava.Imagens.forEach(function (img) {
        if (img.IsThumb === true) {
            ImagemTemp = img;
            return false;
        }
    })
    var Imagem = ImagemTemp ? ImagemTemp : thumbnailPadrao;

    return $('<li>')
        .append($('<img>').attr('src', Imagem.Url).attr('style', 'width: 100px; height: 70px;'))
        .append($('<span>').text(cava.Nome))
        .append(
            $('<button>')
                .on('click', { id: cava.Id, self: this }, this.editarCavaleiroNoServidor)
                .text('Editar')
        )
        .append(
            $('<button>')
                .on('click', { id: cava.Id, self: this }, this.excluirCavaleiroNoServidor)
                .text('Excluir')
        );
};

CavaleiroIndexView.prototype.excluirCavaleiroNoServidor = function (e) {
    var self = e.data.self;
    self.cavaleiros.excluir(e.data.id)
        .done(function (res) {
            self.successToast.show('Excluído com sucesso!');
        });
};

CavaleiroIndexView.prototype.adicionarCavaleiroNoServidor = function (e) {
    var self = e.self;
    self.cavaleiros.inserir(e.cavaleiro)
        .done(function () {
            self.successToast.show('Incluído com sucesso!');
        });
};

CavaleiroIndexView.prototype.editarCavaleiroNoServidor = function(e) {
    var cavaleiroId = e.data.id;
    var self = e.data.self;
    self.cavaleiros.buscar(cavaleiroId)
        .done(function (detalhe) {
            // TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
            cavaleiroHardCoded = detalhe.data;
            simularAtualizacaoHardCoded();
            self.cavaleiros.editar(cavaleiroHardCoded)
                .done(function (res) {
                    self.successToast.show('Cavaleiro atualizado com sucesso!');
                });
        });
};

// TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
function simularAtualizacaoHardCoded() {
    cavaleiroHardCoded.Nome = 'Novo nome após update ' + new Date().getTime();
    cavaleiroHardCoded.AlturaCm = 205;
    cavaleiroHardCoded.Signo = 3;
    cavaleiroHardCoded.TipoSanguineo = 2;
    // Estamos enviando a data UTC (sem timezone) para que seja corretamente armazenada e posteriormente exibida de acordo com o fuso-horário da aplicação cliente que consumir os dados
    cavaleiroHardCoded.DataNascimento = new Date(Date.UTC(2010, 9, 10)).toISOString();
    if (cavaleiroHardCoded.Golpes.length > 0) {
        cavaleiroHardCoded.Golpes[0] = cavaleiroHardCoded.Golpes[0] || {};
        cavaleiroHardCoded.Golpes[0].Nome = 'Voadora do Sub-Zero Brasileiro'
        cavaleiroHardCoded.Golpes[1] = cavaleiroHardCoded.Golpes[1] || {};
        cavaleiroHardCoded.Golpes[1].Nome = 'Cólera dos 42 dragões';
        cavaleiroHardCoded.Golpes[2] = { Nome: 'Novo golpe aterrador' };
    }
    cavaleiroHardCoded.LocalNascimento.Texto = 'Porto Alegre';
    cavaleiroHardCoded.LocalTreinamento.Texto = 'Alvorada';
    if (cavaleiroHardCoded.Imagens.length > 0) {
        cavaleiroHardCoded.Imagens[0] = cavaleiroHardCoded.Imagens[0] || {};
        cavaleiroHardCoded.Imagens[0].Url = 'https://cloud.githubusercontent.com/assets/526075/15443404/5c97dde6-1ebe-11e6-8ae6-83372051dda7.png';
        cavaleiroHardCoded.Imagens[0].IsThumb = true;
        cavaleiroHardCoded.Imagens[1] = cavaleiroHardCoded.Imagens[1] || {};
        cavaleiroHardCoded.Imagens[1].Url = 'https://cloud.githubusercontent.com/assets/526075/15443410/6e9ba586-1ebe-11e6-8b90-64aca9e18a32.png';
        cavaleiroHardCoded.Imagens[1].IsThumb = false;
    }
};

CavaleiroIndexView.prototype.verificaNovosCavaleiros = function (elem) {
    var qtdNovoCavaleiros = 0;
    var self = elem;
    $.get(self.cavaleiros.urlGet).done(
        function (res) {
            res.data.forEach(function (cava) {
                if ($.inArray(cava.Id, cavaleirosListados) === -1) {
                    self.cavaleirosUi.append(
                        self.criarHtmlCavaleiro(cava)
                    );
                    cavaleirosListados.push(cava.Id);
                    qtdNovoCavaleiros++;
                }
            });
            if (qtdNovoCavaleiros > 0) {
                self.exibeNotificationNovosCavaleiros(qtdNovoCavaleiros);                
            }
    });
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