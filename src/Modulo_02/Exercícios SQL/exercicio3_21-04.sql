
--Questao 01
select e.NomeEmpregado, d.NomeDepartamento 
	from Empregado as e 
	inner join Departamento as d 
	on e.IDDepartamento = d.IDDepartamento

--Questao 02
select a.Nome, c.Nome 
	from Associado as a
	left join Cidade as c
	on a.IDCidade = c.IDCidade

--Questao 03
select UF, count(IDCidade) as QtdCidades
	from Cidade 
	where IDcidade not in(
		select IDCidade 
		from Associado 
		where IDCidade is not null)
	group by UF

--Questao 04
select a.Nome, c.nome as Cidade, case 
	when c.UF in ('RS', 'SC', 'PR') then '***'
	else null
	end as PretenceRegiaoSul
	from Associado as a
	inner join Cidade as c 
	on a.IDCidade = c.IDCidade

--Questao 05
select e.NomeEmpregado as Empregado, d.NomeDepartamento as Departamento,
	g.NomeEmpregado as Gerente, d2.NomeDepartamento as Departamento 
		from Empregado as e
		left join Empregado as g 
			on e.IDGerente = g.IDEmpregado
		left join Departamento as d 
			on e.IDDepartamento = d.IDDepartamento 
		left join Departamento as d2
			on g.IDDepartamento = d2.IDDepartamento

--Questao 06
select * into CopiaEmpregado from Empregado

begin transaction
update Empregado set
	Salario = Salario * 1.145
	where IDDepartamento in (
		select IDDepartamento 
		From Departamento 
		where Localizacao = 'SAO PAULO')
commit

--Questao 07
select (sum(e.salario) - Sum(c.Salario)) as ValorReajuste
	from CopiaEmpregado as c
	inner join Empregado as e
	on c.IDEmpregado = e.IDEmpregado

--Questao 08
select top 1 d.NomeDepartamento 
	from Empregado as e
	inner join Departamento as d
	on e.IDDepartamento = d.IDDepartamento
	where e.IDDepartamento is not null
	order by Salario desc

--Questao 09
select a.Nome, c.Nome as Cidade	
	from Associado as a
	inner join Cidade as c
	on a.IDCidade = c.IDCidade
union all
select e.NomeEmpregado as Nome, d.Localizacao as CidadeDepartamento
	from Empregado as e
	inner join Departamento as d
	on e.IDDepartamento = d.IDDepartamento
go

--Questao 10
select Nome, UF from cidade 
	where IDCidade in (
		select IDCidade 
		From Associado
		where IDCidade is not null)