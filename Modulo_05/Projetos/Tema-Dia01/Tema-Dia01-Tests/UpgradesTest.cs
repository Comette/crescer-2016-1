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
    public class UpgradesTest
    {
        [TestMethod]
        public void MegamanTemMais2AtaqueComUpgradeCanhaoPlasma()
        {
            var megaman = new Megaman();
            var inutil = new BOT();
            var upCanhao = new CanhaoPlasma();
            megaman.EquipaUpgrade(upCanhao);
            megaman.Atacar(inutil);
            Assert.AreEqual(92, inutil.Vida);
        }

        [TestMethod]
        public void MegamanTemMais2DefesaComUpgradeEscudoEnergia()
        {
            var megaman = new Megaman();
            var inutil = new BOT();
            var upEscudo = new EscudoEnergia();
            megaman.EquipaUpgrade(upEscudo);
            inutil.Atacar(megaman);
            Assert.AreEqual(97, megaman.Vida);
        }

        [TestMethod]
        public void MegamanTemMais1DefesaE1AtaqueComUpgradeBotasSuperVelocidade()
        {
            var megaman = new Megaman();
            var inutil = new BOT();
            var upBotas = new BotasSuperVelocidade();
            megaman.EquipaUpgrade(upBotas);
            inutil.Atacar(megaman);
            megaman.Atacar(inutil);
            Assert.AreEqual(96, megaman.Vida);
            Assert.AreEqual(93, inutil.Vida);
        }
    }
}
