public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome)
    {
        super(nome);        
    }
    public ElfoVerde (String nome, int flechas)
    {
        super(nome, flechas);        
    }
    @Override
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia+=2;
            anao.levaFlechada();
        }
    }
    @Override
    public void ganhaItem(Item item){
        if(item.getDescricao().equals("Espada de aço valiriano") || 
           item.getDescricao().equals("Arco e Flecha de Vidro")){
            bolsa.adicionaItem(item);
        }
    }
}
