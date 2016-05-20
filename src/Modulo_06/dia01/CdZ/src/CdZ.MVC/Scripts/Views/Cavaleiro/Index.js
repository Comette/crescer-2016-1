'use strict';

var cavaleirosListados = [];
var $cavaleiros = $('#cavaleiros');
function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET'/*, timeout: 2000 */})
    .then(
        function onSuccess(res) {
            console.log(res.data);            
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
                cavaleirosListados.push(cava.Id);
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};
carregarDadosNaPagina();

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });
};
registrarEventoDoBotao();

var qtdNovoCavaleiros;

function verificaNovosCavaleiros() {
    qtdNovoCavaleiros = 0;
    $.get(urlCavaleiroGet).done(
    function(res) {
        res.data.forEach(function (cava) {
            if ($.inArray(cava.Id, cavaleirosListados) === -1){
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
                cavaleirosListados.push(cava.Id);
                qtdNovoCavaleiros++;
            }
        });
        alert('Novos cavaleiros:' + qtdNovoCavaleiros);
    });    
};
var intervalo = 1000 * 5;
setInterval(verificaNovosCavaleiros, intervalo);


