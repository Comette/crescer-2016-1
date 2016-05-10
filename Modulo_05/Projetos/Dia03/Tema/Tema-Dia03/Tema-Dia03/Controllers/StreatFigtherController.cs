using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Tema_Dia03.Models;

namespace Tema_Dia03.Controllers
{
    public class StreatFigtherController : Controller
    {
        //
        // GET: /StreatFigther/
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            SobreMimModel modelo = new SobreMimModel("Victor", 22, 1.82, 76);
            return View(modelo);
        }
	}
}