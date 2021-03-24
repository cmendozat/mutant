package co.com.mercado.libre.exammercadolibre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "MUTANT")
public class MutantEntity {

    @Setter @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    private String dna;

    @Setter @Getter
    private Boolean isMutant;
}
