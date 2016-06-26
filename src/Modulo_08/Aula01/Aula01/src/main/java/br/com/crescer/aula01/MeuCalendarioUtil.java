package br.com.crescer.aula01;

import java.util.Calendar;
import java.util.Date;

public class MeuCalendarioUtil {

    private Calendar calendario = Calendar.getInstance();

    public String diaNascimento(Date dataNascimento) {
        String[] diasDaSemana = new String[]{"", "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        calendario.setTime(dataNascimento);
        int indexDiaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        return diasDaSemana[indexDiaSemana];
    }

    public String tempoDecorrido(Date data) {
        calendario.setTime(data);
        Calendar atual = Calendar.getInstance();
        atual.setTime(new Date());
        int anos = atual.get(Calendar.YEAR) - calendario.get(Calendar.YEAR);
        int meses = 0;
        int dias = 0;
        if (atual.get(Calendar.MONTH) >= calendario.get(Calendar.MONTH)) {
            meses = atual.get(Calendar.MONTH) - calendario.get(Calendar.MONTH);
        } else {
            meses = (atual.get(Calendar.MONTH) + 12) - calendario.get(Calendar.MONTH);
            anos--;
        }
        if (atual.get(Calendar.DAY_OF_MONTH) >= calendario.get(Calendar.DAY_OF_MONTH)) {
            dias = atual.get(Calendar.DAY_OF_MONTH) - calendario.get(Calendar.DAY_OF_MONTH);
        } else {
            dias = (atual.get(Calendar.DAY_OF_MONTH) + 30) - calendario.get(Calendar.DAY_OF_MONTH);
            meses--;
        }
        return String.format("Decorreram %d - anos, %d - meses e %d - dias", anos, meses, dias);
    }

    public static void main(String[] args) {
        System.out.println("\nBem-Vindo(a) ao CalendarioUtil!");
        System.out.println("Métodos disponíveis:\n-diaNascimento-\n-tempoDecorrido-");
    }
}
