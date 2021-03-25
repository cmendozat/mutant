package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.process.MutantProcess;
import co.com.mercado.libre.exammercadolibre.util.MutantUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ObliqueRightMutantProcessor extends MutantProcess {

    public ObliqueRightMutantProcessor(MutantProcess mutantProcess)
    {
        super(mutantProcess);

    }

    @Override
    public boolean isMutant(char[][] dna) {
        int length = dna.length;
        List<String> stringsResults = new ArrayList<>();

        for (
                int diagonal = 1 - length;
                diagonal <= length - 1;
                diagonal += 1
        ) {

            StringBuilder a = new StringBuilder();
            for (
                    int row = Math.max(0, diagonal), column = -Math.min(0, diagonal);
                    row < length && column < length;
                    row += 1, column += 1
            ) {
                a.append(dna[row][column]);
            }

            stringsResults.add(a.toString());
        }

        Pattern pattern = MutantUtil.getPatternMutant();
        boolean result = stringsResults.stream().anyMatch(c -> c.length()>=4 && pattern.matcher(c).find());
        return result ? result : next(dna);
    }
}
