package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.util.MutantUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HorizontalMutantProcessorTest {

    @InjectMocks
    private HorizontalMutantProcessor horizontalMutantProcessor;

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantHorizontal()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};

        assertTrue(horizontalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnFalseWhenDNAisNotMutant()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};

        assertFalse(horizontalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnFalseWhenDNAisNotMutant2()
    {
        String[] dna = {"ATGCGA","CCCTCG","TTATTT","AGACGG","GCGTCA","TCACTG"};

        assertFalse(horizontalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantHorizontal2()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAAGG","CCGCTA","TCCCCT"};

        assertTrue(horizontalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutantHorizontal3()
    {
        String[] dna = {"TTGACT","AACGAC","CCGATG","GCAAGC","CCCCAA","TAGTTC"};

        assertTrue(horizontalMutantProcessor.isMutant(MutantUtil.loadDnaMatriz(dna)));
    }
}
