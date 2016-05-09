using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tema_Dia01.Robos
{
    public class BOT:Robo
    {
        public BOT()
            : base()
        {

        }

        public BOT(EChip chip)
            : base(chip)
        {
            CalculaBonusChip();
        }
    }
}
