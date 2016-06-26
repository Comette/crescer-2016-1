package br.com.crescer.aula01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcelador {

    public String calculaParcelas(double valor, double juros, int qtdParcelas, Date dataInicio) {
        StringBuilder resultado = new StringBuilder("Parcelas:");
        double total = valor + (valor * (juros / 100));
        double parcela = total / qtdParcelas;
        Calendar datas = Calendar.getInstance();
        datas.setTime(dataInicio);
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < qtdParcelas; i++) {
            resultado.append("\n");
            resultado.append(fmt.format(datas.getTime()));
            resultado.append(" - ");
            resultado.append("R$ ");
            resultado.append(parcela);
            datas.add(Calendar.MONTH, 1);
        }
        return resultado.toString();
    }
}
