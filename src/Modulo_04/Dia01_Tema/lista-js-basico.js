'use strict';
//----------01
var daisyGame = function (numPetalas) {
  return numPetalas % 2 !== 0 ? 'Love me' : 'Love me not';
}
//----------02
var maiorTexto = function (array) {
  var textoMaior;
  if (array.constructor === Array) {
    for (var i = 0; i < (array.length - 1); i++) {
      if (array[i].length >= array[i + 1].length) {
        textoMaior = array[i];
      } else {
        textoMaior = array[i + 1];
      }
    }
    alert(textoMaior);
  }
}
//----------03
function imprime(array, fn) {
  for (var i = 0; i < array.length; i++) {
    fn(array[i]);
  }
}
function gambi(instrutor) {
  console.log('olá querido instrutor: ', instrutor);
}
//----------04
function somar(a) {
  return function (b) {
    return a+b;
  }
}
//----------05
function fiboSum(informado) {
  var penultimo = 0;
  var ultimo = 1;
  var resultado = penultimo + ultimo;
  var contador = 1;
  var soma = resultado;
  while (contador < informado) {
    soma += resultado;
    penultimo = ultimo;
    ultimo = resultado;
    resultado = penultimo + ultimo;
    contador++;
  }
  alert('A soma da sequencia Fibonacci até o seu ' + informado + ' algarismo é: ' + soma);
  return soma;
}
//----------06
function queroCafe(mascada, precos) {
  var precosAbaixoMascada;
  precos.sort(function (a, b) { return a - b; });
  for (var i = 0; i < precos.length; i++) {
    if (precos[i] <= mascada) {
      if (typeof precosAbaixoMascada === 'undefined') {
        precosAbaixoMascada = precos[i].toString();
      } else {
        precosAbaixoMascada += ', ' + precos[i].toString();
      }
    }
  }
  return precosAbaixoMascada;
}
//----------07
function contarPorTipo(objeto, tipoDesejado) {
  var tiposPossiveis = ['string', 'number', 'boolean', 'object', 'undefined', 'null', 'function', 'array'];
  var contador = 0;
  if (tiposPossiveis.indexOf(tipoDesejado) > -1) {
    for (var tipo in objeto) {
      if ((typeof objeto[tipo] === tipoDesejado)||
      (tipoDesejado === 'null' && objeto[tipo] === null)||
      (tipoDesejado === 'array' && objeto[tipo].constructor === Array)) {
        contador++;
      }
    }
    alert('O objeto informado possui: ' + contador + ' ' + tipoDesejado + '(s).');
  }
  return contador;
}
//----------08
/*a função tenta retornar uma variavel que esta sendo sobreescrita na própria função!
var gohan = 'Son ' + gohan -> Onde gohan está sendo declarado e instaciado por ele mesmo;
já em "goku = 'Son Goku'" a função refere-se à uma variavel já instanciada anteriormente;
*/
