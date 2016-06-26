
public class CestoDeLembas
{   
    private int nLembas;
    public CestoDeLembas(int num)
    {
        nLembas = num;        
    }
    public boolean podeDividir(){        
        return (nLembas > 2 && nLembas <= 100 && nLembas % 2 == 0);
    }    
}
