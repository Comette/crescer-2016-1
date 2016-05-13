using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
        public int IDPedido { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntrega { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal ValorPedido { get; private set; }
        public TipoPagamento TipoPagamento { get; private set; }
        public bool Urgente { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }

        public Pedido(string nomeProduto, decimal valorProduto, DateTime dataEntrega, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            this.geraID();
            this.geraDataPedido();
            this.NomeProduto = nomeProduto;
            this.ValorPedido = valorProduto;
            this.DataEntrega = dataEntrega;
            this.TipoPagamento = tipoPagamento;
            this.NomeCliente = nomeCliente;
            this.Cidade = cidade;
            this.Estado = estado;           
            this.defineUrgenciaPedido();
        }

        private void geraID()
        {

        }
        private void geraDataPedido()
        {
            this.DataPedido = DateTime.Today;
        }
        private void defineUrgenciaPedido()
        {

        }
    }
}
