using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        // GET: Pedido
        public ActionResult Index()
        {
            return View();
        }

        // GET: Pedido
        public ActionResult Novo(int? id)
        {
            if(id.HasValue)
            {
                return View(id);
            }
            else
            {
                return View();
            }
            
        }

        // POST: Pedido
        public ActionResult Salvar(PedidoModel model)
        {
            if (model.NomeProduto == "Teste")
            {
                ModelState.AddModelError("NomeProduto", "Produto Inválido");
            }
            if(ModelState.IsValid)
            {
                return View();
            }
            else
            {
                return View("Novo", model);
            }
                
        }
    }
}