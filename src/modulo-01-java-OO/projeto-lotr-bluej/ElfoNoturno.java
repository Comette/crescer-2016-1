public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome){
        super(nome);
    }
    @Override
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia+=3;
            vida=vida*0.95;
            // Não morre pois não tem alteração do status conforme perde vida
            anao.levaFlechada();
        }
    }
}
