Select * from Associado

---Questao 01
select left(Nome, (CharIndex(' ', Nome) -1)) from Associado

---Questao 02
select Nome, DATEDIFF(year, dataNascimento, getdate()) as Idade from Associado

---Questao 03
select NomeEmpregado, DATEDIFF(MONTH, DataAdmissao, CONVERT(datetime, '31/12/2000', 103)) as MesesTrabalhados
	 from Empregado 
	 where DataAdmissao between CONVERT(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103)

---Questao 04
select top 1 Cargo, COUNT(IDEmpregado) from Empregado group by Cargo order by count(IDEmpregado) desc

 