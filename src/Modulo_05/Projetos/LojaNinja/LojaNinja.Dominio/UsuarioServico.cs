using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio _usuarioRepositorio;
        public UsuarioServico(IUsuarioRepositorio repositorioUsuarios)
        {
            _usuarioRepositorio = repositorioUsuarios;
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string senhaCriptografada = Criptografar(senha);
            
            Usuario usuarioEncontrado = _usuarioRepositorio.BuscarUsuarioPorAutenticacao(email, senhaCriptografada);

            return usuarioEncontrado;
        }

        public void CadastrarUsuario(string nome, string email, string senha)
        {
            var senhaCriptografada = Criptografar(senha);
            Usuario novo = new Usuario(nome, email, senhaCriptografada);
            _usuarioRepositorio.CadastraUsuario(novo);
        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();

                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                return sBuilder.ToString();
            }
        }
    }
}
