﻿using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\victo\Desktop\vendas.txt";
        private static readonly object objetoLock = new object();

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.IDPedido == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.IDPedido);
                var idGerado = utlimoId + 1;
                pedido.AtualizarId(idGerado);
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);

                File.AppendAllText(PATH_ARQUIVO, novaLinha);
            }
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntrega.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.ValorPedido,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.Urgente);
        }

        public void AtualizarPedido(Pedido pedidoModificado)
        {
            var linhasRepositorio = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            var cabecalho = linhasRepositorio[0];
            var todosPedidos = ConverteLinhasEmPedidos(linhasRepositorio);
            var linhaDoPedido = todosPedidos.FindIndex(ped => ped.IDPedido == pedidoModificado.IDPedido);
            todosPedidos[linhaDoPedido] = pedidoModificado;
            var dados = cabecalho;
            foreach (var ped in todosPedidos)
            {
                dados += ConvertePedidoEmLinhaCSV(ped, ped.IDPedido);
            }
            File.WriteAllText(PATH_ARQUIVO, dados);  
        }

        public void ExcluirPedido(int id)
        {
            var linhasRepositorio = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();
            var cabecalho = linhasRepositorio[0];
            var todosPedidos = ConverteLinhasEmPedidos(linhasRepositorio);
            var linhaDoPedido = todosPedidos.FindIndex(ped => ped.IDPedido == id);
            todosPedidos.RemoveAt(linhaDoPedido);
            var dados = cabecalho;
            foreach (var ped in todosPedidos)
            {
                dados += ConvertePedidoEmLinhaCSV(ped, ped.IDPedido);
            }
            File.WriteAllText(PATH_ARQUIVO, dados);
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }
    }
}
