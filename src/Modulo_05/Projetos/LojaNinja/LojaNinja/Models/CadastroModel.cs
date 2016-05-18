using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class CadastroModel
    {
        [Required(ErrorMessage ="O nome é obrigatório!")]
        [MaxLength(200)]
        public string Nome { get; set; }

        [Required(ErrorMessage = "O email é obrigatório!")]
        [MaxLength(200)]
        [EmailAddress(ErrorMessage ="E-mail inválido! Tente novamente.")]
        public string Email { get; set; }

        [Required(ErrorMessage = "A senha é obrigatória!")]        
        [RegularExpression(@"^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,50}$", ErrorMessage = "A senha não atende os requisitos! Tente novamente.")]
        public string Senha { get; set; }

        [Required(ErrorMessage = "A confirmação de senha é obrigatória!")]
        [Compare("Senha", ErrorMessage ="As senhas não conferem! Tente novamente.")]
        public string ConfirmarSenha { get; set; }

    }
}