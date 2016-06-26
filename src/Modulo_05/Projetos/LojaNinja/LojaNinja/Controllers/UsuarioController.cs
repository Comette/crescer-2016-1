using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        private UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(new RepositorioUsuarios());
        }

        // GET: Usuario
        public ActionResult Login()
        {
            return View();
        }

        public ActionResult Logout()
        {
            ServicoDeSessao.EncerraSessao();
            return RedirectToAction("Index", "Pedido");
        }

        public ActionResult ValidarUser(LoginModel login)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado = _usuarioServico.BuscarUsuarioPorAutenticacao(login.Email, login.Senha);

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    ViewBag.NomeUsuarioLogado = usuarioLogadoModel.Nome;
                    return RedirectToAction("Index", "Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }
            return View("Login");
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult SalvarUsuario(CadastroModel cadastro)
        {
            if (ModelState.IsValid)
            {
                _usuarioServico.CadastrarUsuario(cadastro.Nome, cadastro.Email, cadastro.Senha);
                return View("Salvo");
            }else
            {
                return View("Cadastro");
            }
        }
    }
}