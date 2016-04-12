public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome){
        super(nome);
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    @Override
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia+=3;
            double percentual = 0.05;
            vida = vida - (vida * percentual);
            if(vida < 1){status = Status.MORTO;}
            anao.levaFlechada();
        }
    }
}
