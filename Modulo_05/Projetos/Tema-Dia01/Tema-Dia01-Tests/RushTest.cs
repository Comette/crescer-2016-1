using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tema_Dia01.Robos;
using Tema_Dia01.Upgrade;

namespace Tema_Dia01_Tests
{
    [TestClass]
    public class RushTest
    {
        [TestMethod]
        public void RushNasceCom4Ataque3Vida()
        {
            var rush = new Rush();
            var inutil = new BOT();
            rush.Atacar(inutil);
            inutil.Atacar(rush);
            Assert.AreEqual(98, rush.Vida);
            Assert.AreEqual(96, inutil.Vida);
        }

        [TestMethod]
        public void RushGanhaMais2AtaqueComUpgradeCanhaoPlasma()
        {
            var rush = new Rush();
            var inutil = new BOT();
            var upCanhao = new CanhaoPlasma();
            rush.EquipaUpgrade(upCanhao);
            rush.Atacar(inutil);
            Assert.AreEqual(94, inutil.Vida);
        }

        [TestMethod]
        public void RushAdicionaSeuAtaqueMaisUpgradesQuandoUsadoComoUpgrade()
        {
            var rush = new Rush();
            var megaman = new Megaman();
            var inutil = new BOT();
            var upCanhao = new CanhaoPlasma();
            rush.EquipaUpgrade(upCanhao);
            megaman.EquipaUpgrade(rush);
            megaman.Atacar(inutil);
            Assert.AreEqual(88, inutil.Vida);
        }

        [TestMethod]
        public void RushAdicionaSuaDefesaQuandoUsadoComoUpgrade()
        {
            var rush = new Rush();
            var megaman = new Megaman();
            var inutil = new BOT();
            megaman.EquipaUpgrade(rush);
            inutil.Atacar(megaman);
            Assert.AreEqual(98, megaman.Vida);
        }

        [TestMethod]
        public void RushEquipaOutroRush()
        {
            var rush = new Rush();
            var rush2 = new Rush();
            var inutil = new BOT();
            rush.EquipaUpgrade(rush2);
            inutil.Atacar(rush);
            Assert.AreEqual(100, rush.Vida);
        }
    }
}
