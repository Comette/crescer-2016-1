using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
        [DisplayName("ID do pedido")]
        public int IDPedido { get; private set; }

        [DisplayName("Data do pedido")]
        public DateTime DataPedido { get; private set; }

        [DisplayName("Data de entrega")]
        public DateTime DataEntrega { get; private set; }

        [DisplayName("Nome do produto")]
        public string NomeProduto { get; private set; }

        [DisplayName("Valor do pedido")]
        public decimal ValorPedido { get; private set; }

        [DisplayName("Tipo de pagamento")]
        public TipoPagamento TipoPagamento { get; private set; }

        [DisplayName("Urgência")]
        public bool Urgente { get; private set; }

        [DisplayName("Nome do cliente")]
        public string NomeCliente { get; private set; }

        [DisplayName("Cidade")]
        public string Cidade { get; private set; }

        [DisplayName("Estado")]
        public string Estado { get; private set; }

        public Pedido(string nomeProduto, decimal valorProduto, DateTime dataEntrega, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, int id = 0)
        {
            this.IDPedido = id;
            this.NomeProduto = nomeProduto;
            this.ValorPedido = valorProduto;
            this.geraDataPedido();
            this.DataEntrega = dataEntrega;
            this.validaPrazoDeEntrega();
            this.defineUrgenciaPedido();
            this.TipoPagamento = tipoPagamento;
            this.NomeCliente = nomeCliente;
            this.Cidade = cidade;
            this.Estado = estado;        
        }

        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valorVenda, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool urgente)
        {
            this.IDPedido = id;
            this.DataPedido = dataPedido;
            this.DataEntrega = dataEntregaDesejada;
            this.NomeProduto = nomeProduto;
            this.ValorPedido = valorVenda;
            this.TipoPagamento = tipoPagamento;
            this.NomeCliente = nomeCliente;
            this.Cidade = cidade;
            this.Estado = estado;
            this.Urgente = urgente;
        }        

        public void AtualizarId(int idGerado)
        {
            IDPedido = idGerado;
        }

        private void geraDataPedido()
        {
            this.DataPedido = DateTime.Today;
        }

        private void defineUrgenciaPedido()
        {
            var prazoDesejado = this.DataEntrega.Day - this.DataPedido.Day;
            this.Urgente = (prazoDesejado < 7);
        }

        private void validaPrazoDeEntrega()
        {
            var prazoDesejado = this.DataEntrega - this.DataPedido;
            if (prazoDesejado.Days < 1)
                throw new ArgumentException(
                    "A data de entrega deve ser no mínimo 1 dia após a data atual."
                    );
        }
    }
}
