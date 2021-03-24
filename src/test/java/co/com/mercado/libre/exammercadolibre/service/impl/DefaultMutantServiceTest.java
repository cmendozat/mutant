package co.com.mercado.libre.exammercadolibre.service.impl;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMutantServiceTest {

    @InjectMocks
    private DefaultMutantService defaultMutantService;

    @Test
    public void isMutantTestShouldReturnTrueWhenDNAisMutant()
    {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        assertTrue(defaultMutantService.isMutant(dna));
    }



}
