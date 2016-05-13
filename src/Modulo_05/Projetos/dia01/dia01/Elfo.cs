using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dia01
{
    public class Elfo : Personagem
    {
        public Elfo()
        {
            Flechas = 42;
        }
        private int flechas;
        public int Flechas {
            get
            {
                if (flechas <= 10)
                {
                    return 20;
                }
                else
                {
                    return flechas;
                }
            }
            private set
            {
                flechas = value;
            }
        }

        public void AtirarFlecha()
        {
            Flechas--;
        }
    }
}
