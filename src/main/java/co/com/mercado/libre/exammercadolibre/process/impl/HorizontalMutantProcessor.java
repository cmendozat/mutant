package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.constants.MutantConstants;
import co.com.mercado.libre.exammercadolibre.process.MutantProcess;
import static co.com.mercado.libre.exammercadolibre.util.MutantUtil.isSequence;

public class HorizontalMutantProcessor extends MutantProcess {

    public HorizontalMutantProcessor(MutantProcess mutantProcess)
    {
        super(mutantProcess);

    }

    @Override
    public boolean isMutant(char[][] dna)
    {

        int length = dna.length;
        int sequenceCount = 0;

        for (int row = 0; row<length; row++)
        {

            for(int column = 0; column<length; column++){

                if(isSequence(dna, row, column)){
                    sequenceCount++;
                } else {sequenceCount=0;}

                if(sequenceCount == MutantConstants.MAX_SEQUENCE_COUNT){
                    return true;
                }

            }

        }

        return next(dna);
    }


}
