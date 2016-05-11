import java.util.*;
public interface Estrategia
{
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves);
    public ArrayList<Elfo> getOrdemUltimoAtaque();
}
