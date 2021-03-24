package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.process.MutantProcess;
import co.com.mercado.libre.exammercadolibre.util.MutantUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ObliqueLeftMutantProcessor extends MutantProcess {

    @Override
    public boolean isMutant(char[][] dna)
    {

        List<String> stringsResults = new ArrayList<>();
        getUpperDiagonal(dna, stringsResults);
        getLoweDiagonal(dna, stringsResults);

        Pattern pattern = MutantUtil.getPatternMutant();

        boolean result = stringsResults.stream().anyMatch(c -> c.length()>=4 && pattern.matcher(c).find());
        return result ? result : next(dna);

    }

    private void getUpperDiagonal(char[] [] dna, List<String> stringsResult)
    {
        for (int i=0;i<dna.length;i++) {
            StringBuilder a = new StringBuilder();
            for (int j=0;j<=i;j++) {
                a.append(dna[i-j][j]);
            }
            stringsResult.add(a.toString());
        }
    }

    private void getLoweDiagonal(char[] [] dna, List<String> stringsResult)
    {
        for (int column=0;column<dna.length;column++) {
            StringBuilder b = new StringBuilder();
            for (int row=0;row<dna.length-column-1;row++) {
                b.append(dna[dna.length-column-1][column+row+1]);
            }
            stringsResult.add(b.toString());
        }
    }

}
