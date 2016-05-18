using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class LoginModel
    {
        [Required(ErrorMessage = "O email é obrigatório!")]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress(ErrorMessage = "E-mail inválido! Tente novamente.")]
        public string Email { get; set; }

        [Required(ErrorMessage = "A senha é obrigatória!")]
        [DisplayName("Senha")]
        [StringLength(50)]
        public string Senha { get; set; }
    }
}