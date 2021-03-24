package co.com.mercado.libre.exammercadolibre.converter;

import co.com.mercado.libre.exammercadolibre.dto.MutantDto;
import co.com.mercado.libre.exammercadolibre.entity.MutantEntity;
import co.com.mercado.libre.exammercadolibre.util.MutantUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MutantConverter implements Converter<MutantDto, MutantEntity> {

    @Override
    public MutantEntity convert(MutantDto mutantDto) {
        MutantEntity mutantEntity = new MutantEntity();
        mutantEntity.setDna(MutantUtil.objectToJson(mutantDto));
        mutantEntity.setIsMutant(mutantDto.isMutant());
        return mutantEntity;
    }
}
