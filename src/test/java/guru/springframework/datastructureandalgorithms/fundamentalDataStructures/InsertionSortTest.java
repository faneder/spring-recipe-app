package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortTest {

    @Test
    public void arrayGenerateTest() {
        int[] data = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(100);

        int[ ] orig = Arrays.copyOf(data, data.length);
        System.out.println("data = " + Arrays.toString(data));
        System.out.println("arrays equal before sort: "+Arrays.equals(data, orig));
        Arrays.sort(data); // sorting the data array (orig is unchanged)
    }
}