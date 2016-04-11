public class IrishDwarf extends Dwarf
{      
    public IrishDwarf(String nome)
    {        
        super(nome);        
    }
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {        
        super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            bolsa.multiplica1000Unidades();
        }
    }    
}
