package co.com.mercado.libre.exammercadolibre.validate.impl;

import co.com.mercado.libre.exammercadolibre.constants.MutantConstants;
import co.com.mercado.libre.exammercadolibre.validate.MutantValidate;

public class DefaultMutantValidate implements MutantValidate {

    @Override
    public boolean validate(String [] dna) {
        return dna!= null && isLengthGreaterToFour(dna)
            && isNxNMatriz(dna);
    }

    private boolean isLengthGreaterToFour(String[] dna)
    {
        return dna.length >= MutantConstants.MIN_LENGTH;
    }

    private boolean isNxNMatriz(String[] dna)
    {
        int length = dna.length;
        for(int i=0; i<length;i++){
            if(dna[i].length() != length){
                return false;
            }
        }
        return true;
    }

}
