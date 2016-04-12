public class ElfoNoturno extends Elfo
{
    private double penalidadeVida;
    public ElfoNoturno(String nome){
        super(nome);
        penalidadeVida = vida*0.05;
    }
    @Override
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia+=3;
            vida-=penalidadeVida;
            if(vida <= 0){status = Status.MORTO;}
            anao.levaFlechada();
        }
    }
}
