using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tema_Dia01.Robos;

namespace Tema_Dia01_Tests
{
    [TestClass]
    public class ChipTest
    {
        [TestMethod]
        public void RoboRecebeBonusChipNivel01()
        {
            var robo = new BOT(EChip.Nivel1);
            string esperado = "Nome: BOT, Vida: 100, Ataque: 4, Defesa: 0";
            Assert.AreEqual(esperado, robo.ToString());
        }

        [TestMethod]
        public void RoboNaoAlteraPropriedadesChipNivel02()
        {
            var robo = new BOT(EChip.Nivel2);
            string esperado = "Nome: BOT, Vida: 100, Ataque: 5, Defesa: 0";
            Assert.AreEqual(esperado, robo.ToString());
        }

        [TestMethod]
        public void RoboRecebeBonusChipNivel03()
        {
            var robo = new BOT(EChip.Nivel3);
            string esperado = "Nome: BOT, Vida: 100, Ataque: 7, Defesa: 1";
            Assert.AreEqual(esperado, robo.ToString());
        }
    }
}
