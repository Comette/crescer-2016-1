using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> teste = new List<int>();
            for (int i = 0; i < 10; i++)
            {
                teste.Add(i);
            }
            Console.WriteLine(teste.Count);
            Console.ReadKey();
        }
    }
}
