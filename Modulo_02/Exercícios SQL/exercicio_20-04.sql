
select NomeEmpregado as Nome from Empregado order by DataAdmissao

select NomeEmpregado as Nome,
	(Salario*12) as SalarioAnual
	from Empregado 
	where Cargo = 'Atentende' or (salario*12)< 18500.00

select IDCidade as ID from Cidade where Nome = 'Uberl�ndia'

select IDcidade as ID,
	Nome from Cidade 
	where UF = 'RS'