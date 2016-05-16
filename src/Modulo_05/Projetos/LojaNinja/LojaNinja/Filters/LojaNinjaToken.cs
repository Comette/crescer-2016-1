using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Filters
{
    public class LojaNinjaToken : AuthorizeAttribute
    {
        private string[] _permissoesRequeridas = null;

        public LojaNinjaToken()
        {
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ? null : this.Roles.Split(',');
        }
    }
}