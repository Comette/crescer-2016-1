
public class IrishDwarf
{    
    private int vida = 110;
    private int experiencia;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario bolsa = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    
    public IrishDwarf(String nome)
    {        
        this.nome = nome;        
    }
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {        
        this(nome);
        this.dataNascimento = dataNascimento;
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
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public int getVida(){
        return vida;
    }
    public Status getStatus(){
        return status;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public void ganhaItem(Item item){
        bolsa.adicionaItem(item);
    }
    public void perdeItem(Item item){
        bolsa.removeItem(item);
    }
    public boolean possuiItem(Item item){
        return bolsa.verificaItem(item);
    }
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    public Inventario getInventario(){
        return bolsa;
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
            bolsa.multiplica1000Unidades();
        }
    }    
}
