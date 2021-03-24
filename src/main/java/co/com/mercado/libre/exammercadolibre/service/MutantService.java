package co.com.mercado.libre.exammercadolibre.service;

import co.com.mercado.libre.exammercadolibre.data.StatisticsData;
import co.com.mercado.libre.exammercadolibre.dto.MutantDto;

public interface MutantService {

    /***
     * Method to check if dna is mutant
     * @param dna
     * @return true or false
     */
    boolean isMutant(String[] dna);

    void saveDna(MutantDto mutantDto);

    StatisticsData getStatistics();
}
