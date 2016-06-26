using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tema_Dia01.Robos
{
    public class Megaman : Robo
    {
        public Megaman()
            : base()
        {
            Ataque = 6;
        }

        public Megaman(EChip chip)
            : base(chip)
        {
            Ataque = 6;
            CalculaBonusChip();
        }

        public override void Atacar(Robo oponente)
        {
            int forca = this.CalculaForcaAtaque();
            if (this.Vida <= 30)
            {
                oponente.RecebeAtaque(forca + 3);
            }
            else
            {
                oponente.RecebeAtaque(forca);
            }
        }
    }
}
