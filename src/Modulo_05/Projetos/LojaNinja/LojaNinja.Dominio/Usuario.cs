﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public string Email { get; set; }
        public string Senha { get; set; }

        public string Nome { get; set; }

        public string[] Permissoes { get; set; }

        public Usuario() { }

        public Usuario(string nome, string email, string senha)
        {
            this.Nome = nome;
            this.Email = email;
            this.Senha = senha;
            this.Permissoes = new string[] { "COMUM" };
        }
    }
}
