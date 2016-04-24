Select * from CidadeAux

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

---Questao 05
/*DON'T EXISTS*/

---Questão 06
select Nome, 
	convert(date,DATEADD(year, 50, DataNascimento)) as data50Anos, 
	DATENAME(dw, DATEADD(year, 50, DataNascimento)) as DiaDaSemana 
	From Associado

---Questao 07
select UF, count(IDCidade) as QuantidadeCidades from Cidade group by UF 

---Questao 08
select Nome, UF, count(*) as Repeticoes from Cidade group by Nome, UF having count(*) > 1

---Questao 09
select top 1 (IDCidade+1) as ProximoID from Cidade order by IDCidade desc
 
 ---Questao 10
 truncate table cidadeaux
 insert into CidadeAux (IDCidade, Nome, UF) select MIN(IDCidade), Nome, UF from Cidade group by Nome, UF

 ---Questao 11
 begin transaction
 update Cidade set Nome = '*' + Nome
	 where Nome in (select Nome from Cidade group by Nome, UF having count(*) > 1)
 commit

 ---Questao 12
 select Nome, case Sexo
	when 'F' then 'FEMININO'
	when 'M' then 'MASCULINO'
	else 'Nao Informado'
	end as Sexo from Associado

---Questao 13
select NomeEmpregado, Salario, Case
	when salario <= 1164.00 then '0%'
	when salario between 1164.01 and 2326.00 then '15%'
	when salario > 2326.00 then '27,5%'
	end as PercentualImpostoRenda from Empregado

---Questao 14
begin transaction
delete from Cidade where ((charindex('*', Nome)=1) and IDCidade in (select MAX(IDCidade) from Cidade group by nome, UF))
commit

--Questao 15
begin transaction
alter table cidade add constraint Cidade_UF unique (Nome, UF)
commit
