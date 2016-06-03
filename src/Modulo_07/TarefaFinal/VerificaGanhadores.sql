--COLOCAR CONCURSO DINAMICAMENTE;
DECLARE 
type num_table_type is table of number(5) index by binary_integer;
CURSOR C_APOSTA IS
  SELECT IDAPOSTA FROM APOSTA WHERE IDCONCURSO = 1816;
--
CURSOR C_NUMERO (pIDAPOSTA IN integer)IS
  SELECT NUMERO FROM NUMERO_APOSTA WHERE IDAPOSTA = pIDAPOSTA;
-- 
vSorteados num_table_type; 
vQtdAcertos integer;
vQtdQuadra integer;
vQtdQuina integer;
vQtdSena integer;
BEGIN
vQtdAcertos:=0;
vQtdQuadra:=0;
vQtdQuina:=0;
vQtdSena:=0;
vSorteados(1):=5;
vSorteados(2):=10;
vSorteados(3):=12;
vSorteados(4):=22;
vSorteados(5):=28;
vSorteados(6):=48;
FOR i IN C_APOSTA LOOP
  FOR j IN C_NUMERO(i.IDAPOSTA) LOOP
    FOR k IN 1..6 LOOP
      IF j.NUMERO = vSorteados(k) THEN
        vQtdAcertos:=vQtdAcertos+1;
      END IF;
    END LOOP;
  END LOOP;
  IF (vQtdAcertos = 4) THEN
    vQtdQuadra:=vQtdQuadra+1;
  ELSIF (vQtdAcertos = 5) THEN
    vQtdQuina:=vQtdQuina+1;
  ELSIF (vQtdAcertos = 6) THEN
    vQtdSena:=vQtdSena+1;    
  END IF;
  vQtdAcertos := 0;
END LOOP;
DBMS_OUTPUT.PUT_LINE('Acertos na QUADRA: ' || vQtdQuadra);
DBMS_OUTPUT.PUT_LINE('Acertos na QUINA: ' || vQtdQuina);
DBMS_OUTPUT.PUT_LINE('Acertos na SENA: ' || vQtdSena);
END;

--select * from NUMERO_APOSTA;