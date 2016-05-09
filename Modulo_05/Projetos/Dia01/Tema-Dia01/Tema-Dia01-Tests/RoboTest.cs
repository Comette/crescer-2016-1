using Tema_Dia01.Robos;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tema_Dia01_Tests
{
    [TestClass]
    public class RoboTest
    {
        [TestMethod]
        public void MegamanNasceCom100Vida6Ataque()
        {
            var megaman = new Megaman();
            var inutil = new BOT();
            megaman.Atacar(inutil);
            Assert.AreEqual(100, megaman.Vida);
            Assert.AreEqual(94, inutil.Vida);
        }

        [TestMethod]
        public void MegamanGanha3AtaqueComVidaMenorQue31()
        {
            var megaman = new Megaman();
            var inutil = new BOT();
            for (int i = 0; i < 14; i++)
            {
                inutil.Atacar(megaman);
            }
            megaman.Atacar(inutil);
            Assert.AreEqual(30, megaman.Vida);
            Assert.AreEqual(91, inutil.Vida);
        }

        [TestMethod]
        public void ProtomanNasceCom100Vida2Defesa()
        {
            var protoman = new Protoman();
            var inutil = new BOT();
            inutil.Atacar(protoman);
            Assert.AreEqual(97, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanGanha20VidaEAtaque7QuandoMorre1Vez()
        {
            var protoman = new Protoman();
            var inutil = new BOT();
            for (int i = 0; i < 34; i++)
            {
                inutil.Atacar(protoman);
            }
            protoman.Atacar(inutil);
            Assert.AreEqual(20, protoman.Vida);
            Assert.AreEqual(93, inutil.Vida);
        }

        [TestMethod]
        public void ProtomanGanhaBeneficiosSoNaPrimeiraMorte()
        {
            var protoman = new Protoman();
            var inutil = new BOT();
            for (int i = 0; i < 41; i++)
            {
                inutil.Atacar(protoman);
            }
            Assert.AreEqual(0, protoman.Vida);
        }
    }
}
