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
        consultaArtista(nomeInputado);
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

function buscaAlbum(idArtista){
    var urlBuscaAlbum = 'https://api.spotify.com/v1/artists/' + idArtista + '/albums?limit=50';
    $.get(urlBuscaAlbum).done(function(e){
        e.items.forEach(function(e){
            adicionaImagem(e);
        })
    })    
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