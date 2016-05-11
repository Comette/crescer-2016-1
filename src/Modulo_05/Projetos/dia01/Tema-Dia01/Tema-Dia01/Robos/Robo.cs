using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tema_Dia01.Upgrade;

namespace Tema_Dia01.Robos
{
    public class Robo
    {
        public int Vida { get; protected set; }
        protected int Ataque { get; set; }
        protected int Defesa { get; set; }

        protected EChip Chip;

        protected IUpgrade[] Upgrades { get; set; }

        public Robo()
        {
            Ataque = 5;
            Vida = 100;
            Upgrades = new IUpgrade[3];
            Chip = EChip.Nivel2;
        }

        public Robo(EChip chip)
        {
            Ataque = 5;
            Vida = 100;
            Upgrades = new IUpgrade[3];
            Chip = chip;            
        }

        protected void CalculaBonusChip()
        {
            if (this.Chip == EChip.Nivel1)
            {
                this.Ataque--;
            }
            else if (Chip == EChip.Nivel3)
            {
                this.Ataque += 2;
                this.Defesa++;
            }
        }

        public virtual void Atacar(Robo oponente)
        {
            oponente.RecebeAtaque(this.CalculaForcaAtaque());
        }

        public virtual void RecebeAtaque(int forca)
        {
            int def = this.CalculaPoderDefesa();
            if (this.Vida - (forca - def) < 0)
            {
                this.Vida = 0;
            }
            else if (this.Vida - (forca - def) <= this.Vida)
            {
                this.Vida -= forca - def;
            }
        }

        public void EquipaUpgrade(IUpgrade upgrade)
        {
            for (int i = 0; i < Upgrades.Length; i++)
            {
                if (Upgrades[i] == null)
                {
                    Upgrades[i] = upgrade;
                    break;
                }
            }
        }

        protected int CalculaForcaAtaque()
        {
            int forca = this.Ataque;
            for (int i = 0; i < Upgrades.Length; i++)
            {
                if (Upgrades[i] != null)
                {
                    forca += Upgrades[i].BonusAtaque;
                }                
            }
            return forca;
        }

        protected int CalculaPoderDefesa()
        {
            int def = this.Defesa;
            for (int i = 0; i < Upgrades.Length; i++)
            {
                if (Upgrades[i] != null)
                {
                    def += Upgrades[i].BonusDefesa;
                }                
            }
            return def;
        }

        public override string ToString()
        {
            return "Nome: " + this.GetType().Name + ", Vida: " + this.Vida + ", Ataque: " + this.Ataque + ", Defesa: " + this.Defesa;
        }
    }
}
