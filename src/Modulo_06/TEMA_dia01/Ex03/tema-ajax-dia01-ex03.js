'use strict'

var urlBuscaArtista = 'https://api.spotify.com/v1/search';
var $form = $('#entrada');
var $input = $('#artistaEntrada');
var idArtistaEncontrado;
var $divImagens = $('#imagens');
var $divMsgErro = $('#msgErro');
$(function () {
    $form.submit(function(e){
        var nomeInputado = $input.val();
        if(nomeInputado === 'Justin Bieber'){
            var idJustin = '1uNFoZAHBGtllmzznpCI3s';
            var douchebag = 'douchebag';
            var sorte = Math.random();
            if(sorte <= 0.8){
                buscaAlbum(douchebag, nomeInputado);
            }else{
                buscaAlbum(idJustin, nomeInputado);
            }            
        }else{
            consultaArtista(nomeInputado);
        }
        e.preventDefault();
    });
    
    $('#limpar').click(function(e){
        $divImagens.empty();
        $divMsgErro.empty();
    })
});

function consultaArtista(nome) {
    $.ajax({
        url: urlBuscaArtista,
        type: 'GET',
        data: {
            q: nome,
            type: 'artist'
        }
    }).then(
        function sucesso(e) {
            if(e.artists.items[0]){
                idArtistaEncontrado = e.artists.items[0].id;
                buscaAlbum(idArtistaEncontrado);
            }else{                
                exibeMsgErro('Artista não encontrado!');
            }
            
        }, 
        function erro(){
            exibeMsgErro('Não foi possivel conectar ao spotfi');
        });
};

function buscaAlbum(idArtista, nomeInputado){
    var urlBuscaAlbum = 'https://api.spotify.com/v1/artists/' + idArtista + '/albums?limit=50';
    $.get(urlBuscaAlbum).then(function(e){
            e.items.forEach(function(e){
                adicionaImagem(e);
            })
        },function(e){
            exibeMsgErro('Caro usuário, devido a um erro 400, não foi possível pesquisar por ' + nomeInputado);
        });    
}; 

function adicionaImagem(objSpotfi){    
    var imgPadrao = { url: 'http://vignette3.wikia.nocookie.net/shokugekinosoma/images/6/60/No_Image_Available.png/revision/latest?cb=20150708082716'}
    var urlImagem = (objSpotfi.images[0] || imgPadrao).url;
    $divImagens
        .append( $('<div>')
            .append($('<br>'))
            .append( $('<label>').text(objSpotfi.name)).append($('<br>'))
            .append( $('<img>').attr('src', urlImagem).attr('alt', objSpotfi.name))
        ); 
};

function exibeMsgErro(msg){
    $divMsgErro
        .append($('<span>').attr('class', 'text-danger').text(msg)).append($('<br>'));
};
