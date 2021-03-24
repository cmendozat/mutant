package co.com.mercado.libre.exammercadolibre.controller;

import co.com.mercado.libre.exammercadolibre.data.StatisticsData;
import co.com.mercado.libre.exammercadolibre.dto.MutantDto;
import co.com.mercado.libre.exammercadolibre.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@RestController
public class MutantController {

    private static final Logger LOG = Logger.getLogger(MutantController.class);

    @Autowired
    private MutantService mutantService;

    @PostMapping(value = "/mutant/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void isMutant(@RequestBody MutantDto mutantDto, HttpServletResponse response)
    {
        try {

            boolean isMutant = mutantService.isMutant(mutantDto.getDna());
            mutantDto.setMutant(isMutant);

            if (isMutant) {
                response.setStatus(HttpStatus.OK.value());
            } else {

                response.setStatus(HttpStatus.FORBIDDEN.value());
            }

            mutantService.saveDna(mutantDto);
        } catch (Exception e)
        {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            LOG.error("Error when /mutant service "+ e.getMessage());
        }
    }

    @GetMapping(value = "/stats", produces = {MediaType.APPLICATION_JSON_VALUE})
    public StatisticsData getStatistics()
    {
        try {

            return mutantService.getStatistics();

        } catch (Exception e)
        {
            LOG.error("Error when /mutant service "+ e.getMessage());
            return null;
        }
    }

}
