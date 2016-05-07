using dia01;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TerraMediaTest
{
    [TestClass]
    public class ElfoTest
    {
        [TestMethod]
        public void ElfoAtiraFlechaEDescontaUma()
        {
            var elfo = new Elfo();

            elfo.AtirarFlecha();

            Assert.AreEqual(41, elfo.Flechas);          
        }
        [TestMethod]
        public void ElfoMentirosoTemMaisQue10Flechas()
        {
            var elfo = new Elfo();

            Assert.AreEqual(42, elfo.Flechas);
        }
        [TestMethod]
        public void ElfoMentirosoTemMenosQue10Flechas()
        {
            var elfo = new Elfo();

            for (int i = 0; i < 32; i++)
            {
                elfo.AtirarFlecha();
            }
            Assert.AreEqual(20, elfo.Flechas);
        }
    }
}
