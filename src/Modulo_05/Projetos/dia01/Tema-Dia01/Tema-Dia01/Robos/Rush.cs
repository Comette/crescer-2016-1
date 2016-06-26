using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tema_Dia01.Upgrade;

namespace Tema_Dia01.Robos
{
    public class Rush : Robo, IUpgrade
    {

        public int BonusAtaque
        {
            get { return this.CalculaForcaAtaque(); }
            set
            {
                BonusAtaque = value;
            }
        }

        public int BonusDefesa
        {
            get { return this.Defesa; }
        }

        public Rush()
            : base()
        {
            this.Ataque = 4;
            this.Defesa = 3;
            this.Upgrades = new IUpgrade[2];
        }

        public Rush(EChip chip)
            : base(chip)
        {
            this.Ataque = 4;
            this.Defesa = 3;
            this.Upgrades = new IUpgrade[2];
            CalculaBonusChip();
        }

        public override void Atacar(Robo oponente)
        {
            if (oponente is Megaman)
            {
                oponente.RecebeAtaque(0);
            }
            else
            {
                oponente.RecebeAtaque(this.CalculaForcaAtaque());
            }            
        }
    }
}
