
public class CestoDeLembas
{   
    private int nLembas;
    public CestoDeLembas(int num)
    {
        nLembas = num;        
    }
    public boolean podeDividir(int personagens){
        if(personagens >= 1 && personagens <= 100 && personagens <= nLembas){        
            int lembasPorPersonagem = nLembas / personagens;
            if (lembasPorPersonagem % 2 == 0){
                return true;
            }
        }
        return false;
    }    
}
