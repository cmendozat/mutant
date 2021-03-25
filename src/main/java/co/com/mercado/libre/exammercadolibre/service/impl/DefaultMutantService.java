package co.com.mercado.libre.exammercadolibre.service.impl;

import co.com.mercado.libre.exammercadolibre.converter.MutantConverter;
import co.com.mercado.libre.exammercadolibre.data.StatisticsData;
import co.com.mercado.libre.exammercadolibre.dto.MutantDto;
import co.com.mercado.libre.exammercadolibre.entity.MutantEntity;
import co.com.mercado.libre.exammercadolibre.process.MutantProcess;
import co.com.mercado.libre.exammercadolibre.process.impl.HorizontalMutantProcessor;
import co.com.mercado.libre.exammercadolibre.process.impl.ObliqueLeftMutantProcessor;
import co.com.mercado.libre.exammercadolibre.process.impl.ObliqueRightMutantProcessor;
import co.com.mercado.libre.exammercadolibre.process.impl.VerticalMutantProcessor;
import co.com.mercado.libre.exammercadolibre.repository.MutantRepository;
import co.com.mercado.libre.exammercadolibre.service.MutantService;
import co.com.mercado.libre.exammercadolibre.util.MutantUtil;
import co.com.mercado.libre.exammercadolibre.validate.MutantValidate;
import co.com.mercado.libre.exammercadolibre.validate.impl.DefaultMutantValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMutantService implements MutantService {

    private MutantProcess mutantProcess;
    private MutantValidate mutantValidate;
    @Autowired
    private MutantRepository mutantRepository;

    @Autowired
    private MutantConverter mutantConverter;

    public DefaultMutantService()
    {
        mutantProcess = loadMutantServices();
        mutantValidate = lodValidates();
    }

    @Override
    public boolean isMutant(String[] dna)
    {
        if(!mutantValidate.validate(dna))
        {
            return false;
        }

        char [] [] dnaMatriz = MutantUtil.loadDnaMatriz(dna);

        return mutantProcess.isMutant(dnaMatriz);
    }

    @Override
    public void saveDna(MutantDto mutantDto) {
        mutantRepository.save(mutantConverter.convert(mutantDto));
    }

    @Override
    public StatisticsData getStatistics() {
        List<MutantEntity> mutantEntities = mutantRepository.findAll();
        return createStaticsData(mutantEntities);
    }

    private StatisticsData createStaticsData(List<MutantEntity> mutantEntities)
    {
        StatisticsData statisticsData = new StatisticsData();

        long countMutantDna = mutantEntities.stream().filter(mutantEntity ->
                mutantEntity.getIsMutant()).count();

        statisticsData.setCount_mutant_dna(String.valueOf(countMutantDna));

        long countHumanDna = mutantEntities.stream().count();


        statisticsData.setCount_human_dna(String.valueOf(countHumanDna));

        statisticsData.setRatio(getRatio(countMutantDna, countHumanDna));

        return statisticsData;
    }

    private String getRatio(long countMutantDna, long countHumanDna)
    {
        if(countHumanDna>0 && countMutantDna>0)
        {
            float ratio = (float) countMutantDna / countHumanDna;
            return String.valueOf(ratio);
        }

        return null;
    }


    private MutantProcess loadMutantServices()
    {
        return
                new HorizontalMutantProcessor(new VerticalMutantProcessor(new ObliqueLeftMutantProcessor(new ObliqueRightMutantProcessor(null))));
    }

    private MutantValidate lodValidates()
    {
        return new DefaultMutantValidate();
    }

}
