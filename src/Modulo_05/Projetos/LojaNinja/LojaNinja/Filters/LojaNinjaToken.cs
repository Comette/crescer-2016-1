using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinja.MVC.Filters
{
    public class LojaNinjaToken : AuthorizeAttribute
    {
        
        private string[] _permissoesRequeridas = null;
        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;

                if (this._permissoesRequeridas != null)
                {
                    foreach (string permissao in _permissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }

                return false;
            }
        }

        //Construtor
        public LojaNinjaToken()
        {
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ? null : this.Roles.Split(',');
        }
            
        //Metodos   
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.Logado && TemAutorizacao;
        }
        
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if (!estaAutenticadoEAutorizado)
            {
                // se o usuário não está autenticado nem autorizado, envia ele de volta para a action Index da controller Login.
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Index" },
                                       { "controller", "Login" }
                                   });
            }

        }
    }
}