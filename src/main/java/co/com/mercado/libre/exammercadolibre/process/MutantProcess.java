package co.com.mercado.libre.exammercadolibre.process;

public abstract class MutantProcess {

    public MutantProcess nextProcess;

    public MutantProcess checkIsMutantWith(MutantProcess nextProcess){
        this.nextProcess = nextProcess;
        return nextProcess;
    }


    public abstract boolean isMutant(char dna [] []);

    public boolean next(char dna [] [])
    {
        if (nextProcess == null)
        {
            return false;
        }

        return nextProcess.isMutant(dna);
    }

}
