package co.com.mercado.libre.exammercadolibre.data;

import lombok.Getter;
import lombok.Setter;

public class StatisticsData {

    @Getter
    @Setter
    private String count_mutant_dna;

    @Getter @Setter
    private String count_human_dna;

    @Getter @Setter
    private String ratio;
}
