﻿using LojaNinja.Dominio;
using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        [Required(ErrorMessage = "Nome do produto não informado!")]
        [DisplayName("Nome do produto")]        
        public string NomeProduto { get; set; }

        [Required(ErrorMessage = "Valor do produto não informado!")]
        [DisplayName("Valor do produto")]
        
        public decimal ValorVenda { get; set; }

        [Required(ErrorMessage = "Selecione a data de entrega desejada!")]
        [DisplayName("Data de entrega desejada")]
        public DateTime DataEntrega { get; set; }

        [Required(ErrorMessage = "Forma de pagamento não informada!")]
        [DisplayName("Forma de pagamento")]
        [Range(1, 4, ErrorMessage ="Selecione uma forma de pagamento válida!")]
        public TipoPagamento TipoPagamento { get; set; }

        [Required(ErrorMessage = "Nome do cliente não informado!")]
        [DisplayName("Nome do cliente")]
        public string NomeCliente { get; set; }

        [Required(ErrorMessage = "Cidade do cliente não informada!")]
        public string Cidade { get; set; }

        [Required(ErrorMessage = "Endereço do cliente não informado!")]
        public string Estado { get; set; }

        public PedidoModel() { }
        public PedidoModel(Pedido pedido)
        {
            this.NomeCliente = pedido.NomeCliente;
            this.NomeProduto = pedido.NomeProduto;
            this.ValorVenda = pedido.ValorPedido;
            this.TipoPagamento = pedido.TipoPagamento;
            this.DataEntrega = pedido.DataEntrega;
            this.Cidade = pedido.Cidade;
            this.Estado = pedido.Estado;
        }
    }
}