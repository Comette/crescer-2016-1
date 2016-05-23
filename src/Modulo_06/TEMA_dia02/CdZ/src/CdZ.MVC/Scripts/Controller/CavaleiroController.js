'use strict'

var cadastroView = new CavaleiroCadastroView();

$(function () {
    var $btnNovoCadastro = $('#btnNovoCadastro');
    var $btnFecharCadastro = $('#btnFecharCadastro');
    var $formularioCadastro = $('#frmNovoCavaleiro');
    debugger;

    setInterval(indexView.verificaNovosCavaleiros, 5000, indexView);

    $btnNovoCadastro.click(function (e) {
        $formularioCadastro.show();
        $btnNovoCadastro.hide();
    });

    $btnFecharCadastro.click(function (e) {
        $formularioCadastro[0].reset();
        $formularioCadastro.hide();
        $btnNovoCadastro.show();
    });

    $('#btnAdicionarGolpe').click(function () {
        cadastroView.adicionarCampoGolpe();
    })

    $('#btnAdicionarImg').click(function () {
        cadastroView.adicionarCampoImagem();
    })

    $formularioCadastro.submit(function (e) {
        var cavaleiro = cadastroView.converteFormParaCavaleiro($formularioCadastro);
        if (cavaleiro.Id > 0) {
            indexView.editarCavaleiroNoServidor({ self: indexView, cavaleiro: cavaleiro });
        } else {
            indexView.adicionarCavaleiroNoServidor({ self: indexView, cavaleiro: cavaleiro });
        }
        debugger;
        $formularioCadastro[0].reset();
        $formularioCadastro.hide();
        $btnNovoCadastro.show();
        return e.preventDefault();
    })
})
