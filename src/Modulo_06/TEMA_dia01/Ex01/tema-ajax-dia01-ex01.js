'use strict'

var url = 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50';

$(function(){    
    $.get(url).done(function(res){
        res.items.forEach(function(e){   
            adicionaImagem(e);                    
        });
    });       
});

function adicionaImagem(objSpotfi){
    var $divImagens = $('#imagens');
    $divImagens
        .append( $('<div>')
            .append($('<br>'))
            .append( $('<label>').text(objSpotfi.name)).append($('<br>'))
            .append( $('<img>').attr('src', objSpotfi.images[0].url).attr('alt', objSpotfi.name))
        ); 
};