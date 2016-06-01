-- Ex 01 ---------------------------------------------------
declare
vNome_Cliente Cliente.Nome%TYPE;
vNome_Cidade Cidade.Nome%TYPE;
vData_Primeiro_Pedido PEDIDO.DATAPEDIDO%TYPE;
vData_Ultimo_Pedido PEDIDO.DATAPEDIDO%TYPE;
vValor_Total_Pedidos PEDIDO.VALORPEDIDO%TYPE;
begin 
SELECT cli.NOME, cid.NOME, MIN(ped.DATAPEDIDO), MAX(ped.DATAPEDIDO), SUM(ped.VALORPEDIDO)
INTO vNome_Cliente, vNome_Cidade, vData_Primeiro_Pedido, vData_Ultimo_Pedido, vValor_Total_Pedidos
FROM Cliente cli
INNER JOIN CIDADE cid on cid.IDCIDADE = cli.IDCIDADE
INNER JOIN PEDIDO ped on ped.IDCLIENTE = cli.IDCLIENTE
WHERE cli.IDCLIENTE=&pIDCliente
GROUP BY cli.NOME, cid.NOME;

DBMS_OUTPUT.PUT_LINE(vNome_Cliente || ' ' || vNome_Cidade || ' ' || vData_Primeiro_Pedido || ' ' || vData_Ultimo_Pedido || ' ' || vValor_Total_Pedidos);
end;


-- Ex02 ---------[INCOMPLETO]---------------------
declare
vID_Cidade CIDADE.IDCIDADE%TYPE;
vNome_Cidade CIDADE.NOME%TYPE;
vUF_Cidade CIDADE.UF%TYPE;
vCidadeExistente CIDADE.IDCIDADE%TYPE;
begin
vNome_Cidade:='&pNomeCidade';
vUF_Cidade:='&pUFCidade';
Select Count(1) into vCidadeExistente from CIDADE where NOME = vNome_Cidade and UF = vUF_Cidade;
DBMS_OUTPUT.PUT_LINE(vCidadeExistente || ' ' || vNome_Cidade || ' ' || vUF_Cidade);
end;

