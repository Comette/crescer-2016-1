using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        private const TurnoTrabalho MANHA = TurnoTrabalho.Manha;
        private const TurnoTrabalho TARDE = TurnoTrabalho.Tarde;
        private const TurnoTrabalho NOITE = TurnoTrabalho.Noite;

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(Func => Func.Cargo.Equals(cargo)).ToList();
        } //ok

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(func => func.Cargo.Titulo).ThenBy(func => func.Nome).ToList();
        } //ok

        public IList<Funcionario> BuscarPorNome(string nome) //ok
        {            
            return Funcionarios.Where(func => (func.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) >= 0) ).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {                      
            return Funcionarios.Where(func => turnos.Contains(func.TurnoTrabalho)).ToList();
        } //ok

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            DateTime hoje = new DateTime();
            hoje=DateTime.Today;
            return Funcionarios.Where(func => 
                (
                    ((hoje.Year - func.DataNascimento.Year) >= (idade - 5)) && 
                    ((hoje.Year - func.DataNascimento.Year) <= (idade + 5))
                )
             ).ToList();
        } //ok

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if (turno != null)
            {
                return Funcionarios.Where(func => func.TurnoTrabalho == turno).Average(func => func.Cargo.Salario);
            }
            else
            {
                return Funcionarios.Average(func => func.Cargo.Salario);
            }            
        } //ok

        public IList<Funcionario> AniversariantesDoMes()
        {
            DateTime hoje = new DateTime();
            hoje = DateTime.Now;
            return Funcionarios.Where(func => func.DataNascimento.Month == hoje.Month).ToList();

        }  //ok

        public IList<dynamic> BuscaRapida()
        {
            return Funcionarios.Select(func => (dynamic)(new { NomeFuncionario = func.Nome, TituloCargo = func.Cargo.Titulo })).ToList();
        } //ok

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            TurnoTrabalho[] todosOsTurnos = new TurnoTrabalho[3] { TurnoTrabalho.Manha, TurnoTrabalho.Tarde, TurnoTrabalho.Noite };

            var funcionariosOrdanados = todosOsTurnos.Select(turno => (dynamic)(new { Turno = turno, Quantidade = (Funcionarios.Count(fun => fun.TurnoTrabalho == turno)) })).ToList();

            return funcionariosOrdanados;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            //10) FuncionarioMaisComplexo()

            //Retornar o funcionário cujo nome tenha mais consoantes, porém esse funcionário não pode ser "Desenvolvedor Júnior" nem do turno da tarde. O retorno deve ser um objeto que contenha as seguintes propriedades:

            //    Nome (nome do funcionário)
            //    DataNascimento (data denascimento do funcionário no formato "25/01/2016")
            //    SalarioRS (salário do funcionário no formato brasileiro, exemplo: "R$ 999,99")
            //    SalarioUS (salário do funcionário no formato americano, exemplo: ""$999.99")
            //    QuantidadeMesmoCargo (quantidade de funcionários que estão no mesmo cargo que ele)

            //Funcionarios.Where(func => (func.Cargo.Titulo != "Desenvolvedor Júnior") && (func.Nome.ToLower().Count(letra => consoantes.Contains(letra)) == Funcionarios.Max(func => func.Nome.ToLower().Count(letra => consoantes.Contains(letra)))   )).Select(Func => new { Nome = Func.Nome });

            Char[] consoantes = new Char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'w', 'y', 'z' };
            var funcionarioQueAtende = Funcionarios.Where(func => (func.Cargo.Titulo != "Desenvolvedor Júnior")).Max(func => func.Nome.ToLower().Count(letra => consoantes.Contains(letra)));
            return Funcionarios.Where(func => ((func.Cargo.Titulo != "Desenvolvedor Júnior") && (func.Nome.ToLower().Count(letra => consoantes.Contains(letra)) == Funcionarios.Max(fun => fun.Nome.ToLower().Count(letra => consoantes.Contains(letra)))))).Select(func => (dynamic)(new { Nome = func.Nome }));            
        }
    }
}
