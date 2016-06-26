--PARTE 1------Ex01---------------------------------------------------
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


--PARTE 1-------Ex02------------------------------
SELECT MAX(IDCIDADE) FROM CIDADE;
CREATE SEQUENCE IDCIDADE_SEQ START WITH 4669;
declare
vID_Cidade CIDADE.IDCIDADE%TYPE;
vNome_Cidade CIDADE.NOME%TYPE;
vUF_Cidade CIDADE.UF%TYPE;
vCidadeExistente CIDADE.IDCIDADE%TYPE;
begin
vNome_Cidade:='&pNomeCidade';
vUF_Cidade:='&pUFCidade';
Select Count(1) into vCidadeExistente from CIDADE where LOWER(NOME) = LOWER(vNome_Cidade) and LOWER(UF) = LOWER(vUF_Cidade);
IF vCidadeExistente > 0 THEN  
  DBMS_OUTPUT.PUT_LINE('Já existe uma cidade cadastrada com esse nome e UF: ID = ' || vCidadeExistente || ' NOME = ' || vNome_Cidade || ' UF = ' || vUF_Cidade);
ELSE
  INSERT INTO CIDADE VALUES (IDCIDADE_SEQ.NEXTVAL, vNome_Cidade, vUF_Cidade);
  DBMS_OUTPUT.PUT_LINE('Cidade inserida com sucesso!');
  COMMIT;
END IF;
end;
SELECT * FROM CIDADE ORDER BY IDCIDADE DESC;

--PARTE 2------Ex01-----------------------------------------------------
DECLARE
vIDPedido PEDIDO.IDPEDIDO%TYPE;
vValorPedido PEDIDO.VALORPEDIDO%TYPE;
BEGIN
  vIDPedido:=&IDPedido;
  SELECT SUM(QUANTIDADE * PRECOUNITARIO) INTO vValorPedido FROM PEDIDOITEM WHERE IDPEDIDO = vIDPedido;
  IF vValorPedido > 0 THEN
    UPDATE PEDIDO SET VALORPEDIDO = vValorPedido WHERE IDPEDIDO = vIDPedido;
    DBMS_OUTPUT.PUT_LINE('Valor do Pedido(' || vIDPedido || ') atualizado com sucesso!');
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Pedido não encontrado!');
  END IF;  
END;

--PARTE 2-------Ex02------------------------------------------------
DECLARE
vIdCliente CLIENTE.IDCLIENTE%TYPE;
vDataUltimoPedido PEDIDO.DATAPEDIDO%TYPE;
BEGIN
vIdCliente:=&IDCliente;
SELECT MAX  (DATAPEDIDO) INTO vDataUltimoPedido FROM PEDIDO WHERE IDCLIENTE = vIdCliente;
IF TO_CHAR(vDataUltimoPedido) IS NULL THEN
  DBMS_OUTPUT.PUT_LINE('Cliente não encontrado ou não possui pedidos!');
ELSE
  DBMS_OUTPUT.PUT_LINE('Ultimo pedido realizado em ' || vDataUltimoPedido);
END IF;
END;

--PARTE 2-----Ex 03--------------------------------
DECLARE
vIDProduto PRODUTO.IDPRODUTO%TYPE;
vPeriodo VARCHAR2;
vInicio PEDIDO.DATAPEDIDO%TYPE;
vFinal PEDIDO.DATAPEDIDO%TYPE;
vTotalVendas PEDIDOITEM.QUANTIDADE%TYPE;
BEGIN
vIDProduto:=&IDProduto;
vPeriodo:=TO_CHAR(&Periodo, 'MM-YYYY');
vInicio:=TO_DATE('01-' || vPeriodo);
vFinal:=LAST_DAY(vInicio);
SELECT SUM(QUANTIDADE) 
    INTO vTotalVendas
    FROM PEDIDOITEM 
    WHERE IDPRODUTO = vIDProduto 
      AND IDPEDIDO IN(
        SELECT IDPEDIDO 
        FROM PEDIDO 
        WHERE DATAPEDIDO BETWEEN vInicio AND vFinal
      );
END;