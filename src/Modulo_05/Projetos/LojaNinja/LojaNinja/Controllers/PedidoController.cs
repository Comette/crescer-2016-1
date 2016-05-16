using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Globalization;
using System.Linq;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        // GET: Pedido
        public ActionResult Index()
        {
            return View();
        }
        // GET: Pedido
        public ActionResult Novo(int? id)
        {
            if (id.HasValue)
            {
                ViewBag.IDPedido = id;
                var pedidoQueSeraEditado = repositorio.ObterPedidoPorId(ViewBag.IDPedido);
                var pedidoQueSeraEditadoModel = new PedidoModel(pedidoQueSeraEditado);
                return View(pedidoQueSeraEditadoModel);
            }
            else
            {
                return View();
            }

        }

        // POST: Pedido
        public ActionResult Salvar(PedidoModel model, int id)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    if (id == 0)
                    {
                        Pedido pedido = new Pedido(model.NomeProduto, model.ValorVenda, model.DataEntrega, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);
                        repositorio.IncluirPedido(pedido);
                    }
                    else
                    {
                        Pedido pedido = new Pedido(model.NomeProduto, model.ValorVenda, model.DataEntrega, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado, id);
                        repositorio.AtualizarPedido(pedido);
                    }
                    
                    return View();
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    ViewBag.IDpedido = id;
                    return View("Novo", model);
                }               
            }
            else
            {
                ViewBag.IDpedido = id;
                return View("Novo", model);
            }

        }

        public ActionResult Listagem(string nomeCliente, string nomeProduto)
        {
            var pedidos = repositorio.ObterPedidos();
            if (!string.IsNullOrWhiteSpace(nomeCliente))
            {
                pedidos = pedidos.Where(ped => (string.Compare(nomeCliente, ped.NomeCliente, CultureInfo.CurrentCulture, CompareOptions.IgnoreNonSpace | CompareOptions.IgnoreCase) == 0)).ToList();
            }
            if(!string.IsNullOrWhiteSpace(nomeProduto))
            {
                pedidos = pedidos.Where(ped => (string.Compare(nomeProduto, ped.NomeProduto, CultureInfo.CurrentCulture, CompareOptions.IgnoreNonSpace | CompareOptions.IgnoreCase) == 0)).ToList();
            }
            if(pedidos.Count < 1)
            {
                ViewBag.Erro = "Não há pedidos que atendem aos parâmetros buscados";
            }
            return View(pedidos);
        }
        
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);
            return View(pedido);
        }

        public ActionResult Deletar(int id)
        {            
            var pedido = repositorio.ObterPedidoPorId(id);
            return View(pedido);
        }
        public ActionResult Excluido(int id)
        {
            repositorio.ExcluirPedido(id);
            return View();
        }

    }
}