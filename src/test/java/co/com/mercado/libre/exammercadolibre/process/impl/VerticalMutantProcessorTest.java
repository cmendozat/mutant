package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.util.MutantUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class VerticalMutantProcessorTest {

    @InjectMocks
    private VerticalMutantProcessor verticalMutantProcessor;

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantHorizontal()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};

        assertTrue(verticalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnFalseWhenDNAisNotMutant()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};

        assertFalse(verticalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnFalseWhenDNAisNotMutant2()
    {
        String[] dna = {"ATGCGA","CCCTCG","TTATTT","AGACGG","GCGTCA","TCACTG"};

        assertFalse(verticalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantHorizontal2()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAAGG","CCGCTA","TCCCCT"};

        assertTrue(verticalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantVertical()
    {
        String[] dna = {"ATGC","AACT","AGCA","ATAG"};

        assertTrue(verticalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }
}
