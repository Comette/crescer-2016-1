using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tema_Dia03.Models
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public int Idade { get; set; }
        public double Altura { get; set; }
        public int Peso { get; set; }

        public SobreMimModel(string nome, int idade, double altura, int peso)
        {
            this.Nome = nome;
            this.Idade = idade;
            this.Altura = altura;
            this.Peso = peso;
        }

    }
}