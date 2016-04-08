public class Dwarf
{
    private int vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario bolsa = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    
    public Dwarf(String nome)
    {        
        this.nome = nome;        
    }
    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {        
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    public void levaFlechada(){
      if(vida >= 10){
          vida -= 10;
      }else{
          vida = 0;
      }
      if(vida == 0){
            status = Status.MORTO;
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
}
