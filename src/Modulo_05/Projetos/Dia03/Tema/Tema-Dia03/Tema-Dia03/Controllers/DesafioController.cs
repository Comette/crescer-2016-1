using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Tema_Dia03.Controllers
{
    public class DesafioController : Controller
    {
        //
        // GET: /Desafio/
        public ActionResult Index(string aluno)
        {
            
            var todosEstilos = new string[] { "alana", 
                                          "alice", 
                                          "alycio", 
                                          "andrews", 
                                          "arthur", 
                                          "calvingerling", 
                                          "davi", 
                                          "diuly", 
                                          "douglas", 
                                          "erico", 
                                          "fabriciorissetto", 
                                          "fernando", 
                                          "gustavo", 
                                          "hedo", 
                                          "leon", 
                                          "marcelo", 
                                          "mauricio", 
                                          "michel", 
                                          "murillo", 
                                          "victor", 
                                          "viniciusambrosi", 
                                          "viniciusAudibert"
            };
            if ((aluno!=null)&&(todosEstilos.Contains(aluno)))
            {
                ViewBag.Estilo = aluno;
                return View();
            }
            else
            {
                TempData["Erro"] = "ERRO!: aluno não informado ou inválido";
                return View("Erro");
            }
            
        }
	}
}