
---Faça uma consulta (query) que retorne o nome dos empregados 
---exibindo em ordem de admissão.
select NomeEmpregado as Nome from Empregado order by DataAdmissao

---Faça uma consulta que retorne o nome dos empregados e o salário anual,
---onde o cargo seja Atendente ou que o salário anual seja inferior a R$ 18.500,00.
select NomeEmpregado as Nome,
	(Salario*12) as SalarioAnual
	from Empregado 
	where Cargo = 'Atentende' or (salario*12)< 18500.00

---Retornar o ID da cidade de Uberlândia.
select IDCidade as ID from Cidade where Nome = 'Uberlândia'

---Exibir todas as cidades (ID e nome) do estado do Rio Grande do Sul.
select IDcidade as ID,
	Nome from Cidade 
	where UF = 'RS'