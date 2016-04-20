import java.util.*;
public class Dwarf extends Personagem
{    
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);    
    public Dwarf(String nome)
    {        
        super(nome); 
        vida = 110.0;
    }
    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {        
        super(nome);
        this.dataNascimento = dataNascimento;
        vida = 110.0;
    }
    public void levaFlechada(){
        double numeroSorte = this.getNumeroSorte();
        if(numeroSorte < 0){
            experiencia += 2;
        }else if(numeroSorte > 100){  
            if(vida >= 10){
                vida -= 10;
            }else{
                vida = 0;
            }
            if(vida == 0){
                status = Status.MORTO;
            }
        }
    }         
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    public double getNumeroSorte(){
        double valorRetornar = 101.0;
        if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90){
            return valorRetornar * (-33);
        }
        if(!dataNascimento.ehBissexto() && (nome.equals("Seixas") || nome.equals("Meireles"))){
            return ((valorRetornar * 33) % 100);
        }
        return valorRetornar;
    }
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            bolsa.adiciona1000Unidades();
        }
    }    
    
    public static Dwarf descobreMenosVida(Dwarf dwarf1, Dwarf dwarf2){
        return dwarf1.getVida() < dwarf2.getVida() ? dwarf1 : dwarf2;
    }
    
}







