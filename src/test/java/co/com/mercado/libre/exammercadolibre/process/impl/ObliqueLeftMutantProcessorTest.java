package co.com.mercado.libre.exammercadolibre.process.impl;

import co.com.mercado.libre.exammercadolibre.util.MutantUtil;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ObliqueLeftMutantProcessorTest {

    @InjectMocks
    private  ObliqueLeftMutantProcessor obliqueLeftMutantProcessor;

    @Test
    public void isMutantTest()
    {
        ;

       // assertTrue(obliqueLeftMutantProcessor.isMutant());
    }

    @Test
    public void isMutantTest2()
    {

        String[] dna = {"ATGCGA","CAGGGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};



        // Define los números.
       /* Integer[][] matriz = {
                {  0,  1,  2,  3,  4,  5 },
                {  6,  7,  8,  9, 10, 11 },
                { 12, 13, 14, 15, 16, 17 },
                { 18, 19, 20, 21, 22, 23 },
                { 24, 25, 26, 27, 28, 29 },
                { 30, 31, 32, 33, 34, 35 }
        };*/

       String regex = "[A]{4}|[T]{4}|[C]{4}|[G]{4}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);


        char [][] matriz = MutantUtil.loadDnaMatriz(dna);

        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;

        for (
            // Recorre los inicios de cada diagonal en los bordes de la matriz.
                Integer diagonal = 1 - anchura; // Comienza con un número negativo.
                diagonal <= altura - 1; // Mientras no llegue a la última diagonal.
                diagonal += 1 // Avanza hasta el comienzo de la siguiente diagonal.
        ) {

            String a = Strings.EMPTY;

            for (
                // Recorre cada una de las diagonales a partir del extremo superior izquierdo.
                    Integer vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
                    vertical < altura && horizontal < anchura; // Mientras no excedan los límites.
                    vertical += 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
            ) {

                a += String.valueOf(matriz[vertical][horizontal]);
                // Muestra cada punto de la matriz ordenadamente.
                //System.out.println(matriz[vertical][horizontal] + " Coordenadas -> "+horizontal + " "+ vertical);
            }

            System.out.println(a + " - "+ pattern.matcher(a).find());
        }
    }



    @Test
    public void isMutantTest3()
    {

        String[] dna = {"ATGCGA","CAGGGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};


        String regex = "[A]{4}|[T]{4}|[C]{4}|[G]{4}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);


        char [][] matriz = MutantUtil.loadDnaMatriz(dna);

        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;

        for (
            // Recorre los inicios de cada diagonal en los bordes de la matriz.
                Integer diagonal = 0; // Comienza con un número negativo.
                diagonal <= altura - 1; // Mientras no llegue a la última diagonal.
                diagonal += 1 // Avanza hasta el comienzo de la siguiente diagonal.
        ) {

            String a = Strings.EMPTY;

            for (
                // Recorre cada una de las diagonales a partir del extremo superior izquierdo.
                    Integer vertical = 0, horizontal = diagonal;
                    vertical < altura && horizontal < altura; // Mientras no excedan los límites.
                    vertical += 1, horizontal -= 1 // Avanza en diagonal incrementando ambos ejes.
            ) {

                a += String.valueOf(matriz[horizontal][vertical]);
                // Muestra cada punto de la matriz ordenadamente.
                System.out.println(matriz[horizontal][vertical] + " Coordenadas -> "+horizontal + " "+ vertical);
            }

            System.out.println(a + " - "+ pattern.matcher(a).find());
        }
    }

    @Test
    public void isMutant4()
    {

        String[] dna = {"ATGCGA","CAGGGC","TTTTGT","AGAAGG","CCCCTA","TCACTG"};


        String regex = "[A]{4}|[T]{4}|[C]{4}|[G]{4}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);


        char [][] matriz = MutantUtil.loadDnaMatriz(dna);

        // Calcula la altura y la anchura de la matriz introducida.
        Integer altura = matriz.length, anchura = matriz[0].length;

        for (int i=0;i<altura;i++) {
            String a = Strings.EMPTY;
            for (int j=0;j<=i;j++) {
                a+= matriz[i-j][j];
            }
            System.out.println(a);
        }

//segunda parte diagonal inferior
        for (int i=0;i<matriz.length;i++) {
            String b = Strings.EMPTY;
            for (int j=0;j<matriz.length-i-1;j++) {
                b+= matriz[matriz.length-j-1][j+i+1];
            }
            System.out.println(b);
        }
    }
}
