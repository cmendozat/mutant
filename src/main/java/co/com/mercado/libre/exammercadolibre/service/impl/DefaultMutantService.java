package co.com.mercado.libre.exammercadolibre.service.impl;

import co.com.mercado.libre.exammercadolibre.converter.MutantConverter;
import co.com.mercado.libre.exammercadolibre.data.StatisticsData;
import co.com.mercado.libre.exammercadolibre.dto.MutantDto;
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
        return null;
    }


    private MutantProcess loadMutantServices()
    {
        return   new HorizontalMutantProcessor()
                .checkIsMutantWith(new VerticalMutantProcessor())
                .checkIsMutantWith(new ObliqueLeftMutantProcessor())
                .checkIsMutantWith(new ObliqueRightMutantProcessor());
    }

    private MutantValidate lodValidates()
    {
        return new DefaultMutantValidate();
    }

}
