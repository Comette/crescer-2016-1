public class Item
{
    private int quantidade;
    private String descricao;
    public Item(int quantidade, String descricao)
    {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public String getDescricao(){
        return descricao;
    }
    public void aumenta1000(){
        quantidade += 1000;
    }
    public void multiplica1000(){       
        int soma = quantidade * (quantidade + 1) /2;
        quantidade += soma * 1000;
    }
    public boolean equals(Object obj){
        Item outro = (Item)obj;
        boolean saoIguais =this.quantidade == outro.quantidade && this.descricao.equals(outro.descricao);
        return saoIguais;
    }
}
