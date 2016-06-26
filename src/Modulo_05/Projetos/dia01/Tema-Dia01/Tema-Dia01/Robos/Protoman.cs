using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tema_Dia01.Robos
{
    public class Protoman : Robo
    {
        private bool jaMorreu = false;

        public Protoman()
            : base()
        {
            Defesa = 2;
        }

        public Protoman(EChip chip)
            : base(chip)
        {
            Defesa = 2;
            CalculaBonusChip();
        }

        public override void RecebeAtaque(int forca)
        {
            int def = this.CalculaPoderDefesa();
            if ((this.Vida - (forca - def) <= 0) && (!jaMorreu))
            {
                this.Vida = 20;
                this.Ataque = 7;
                jaMorreu = true;
            }
            else if (this.Vida - (forca - def) < 0)
            {
                this.Vida = 0;
            }
            else if (this.Vida - (forca - def) <= this.Vida)
            {
                this.Vida -= forca - def;
            }
        }
    }
}
