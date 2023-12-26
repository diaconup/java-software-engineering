package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n - 1; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    public static int[] findMaxAndMin(int[] array) {
        int[] min = new int[2];
        min[0] = 101;
        min[1] = -1;
        for(int i = 0; i < array.length - 1; i++) {
            if (min[0] > array[i])
                min[0] = array[i];
            if (min[1] < array[i])
                min[1] = array[i];
        }
        return min;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size - 1);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
