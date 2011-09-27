package util;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author geovane
 */
public class Generator {
    

    public static String randomNumbers(int quantity, int min, int max) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        int value = 0;
        StringBuilder sb = new StringBuilder();
        Random random = new java.util.Random();
        for(int i=0; i < quantity; i++){
            do{
               value = random.nextInt(max);
            }while(numbers.contains(value) || value < min);
            numbers.add(value);
            sb.append(value);
            sb.append("\n");
        }
        return sb.toString();
    }
}
