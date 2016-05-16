using Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["UsuariosDB"].ConnectionString;
            var conexao = new SqlConnection(connectionString);

            Usuario usuario = null;
            using (conexao)
            {
                string query = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(query, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                if(leitor.Read())
                {
                    usuario = new Usuario() { Nome = (string)leitor["nome"], Email = (string)leitor["email"], Senha = (string)leitor["senha"] };
                }
            }

            return usuario;
        }
    }
}
