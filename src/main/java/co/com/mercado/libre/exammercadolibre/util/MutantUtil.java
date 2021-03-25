package co.com.mercado.libre.exammercadolibre.util;

import co.com.mercado.libre.exammercadolibre.constants.MutantConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;

public class MutantUtil {

    private MutantUtil(){}

    public static char getNext(char array[], int currentPosition)
    {
        int next = currentPosition + 1;
        char charReturn = ' ';
        int length = array.length;

        if(currentPosition<length && next<length)
        {
            charReturn =  array[next];
        }

        return charReturn;
    }

    public static boolean isSequence(char[][] dna, int row, int column)
    {
        char next = getNext(dna[row],column);

        return dna[row] [column] == next;
    }

    public static boolean isSequenceVertical(char[][] dna, int column, int row)
    {
        char next = getNextVertical(dna,column, row);

        return dna[row] [column] == next;
    }

    private static char getNextVertical(char[][] dna, int column, int row)
    {

        int next = row + 1;
        char charReturn = ' ';
        int length = dna.length;

        if( next<length)
        {
            charReturn =  dna[row+1] [column];
        }

        return charReturn;
    }

    public static char [] [] loadDnaMatriz(String[] dna)
    {
        int lenght = dna.length;
        char [] [] dnaMatriz = new char[lenght][lenght];

        for (int i=0;i<lenght;i++)
        {
            dnaMatriz[i] = dna[i].toCharArray();
        }

        return dnaMatriz;
    }

    public static Pattern getPatternMutant()
    {
        return Pattern.compile(MutantConstants.REGEX, Pattern.MULTILINE);
    }

    public static String objectToJson(Object myObject)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try
        {
            return objectMapper.writeValueAsString(myObject);
        }
        catch (JsonProcessingException e)
        {
            return null;
        }

    }
}
