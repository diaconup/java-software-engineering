package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] array = input.split(",");

        int[] rez = {-1, -1, 1000, -1};

        for(int i = 0; i < array.length; i++) {
            if(Integer.parseInt(array[i]) % 2 == 0) {
                if (Integer.parseInt(array[i]) > rez[0]) {
                    rez[0] = Integer.parseInt(array[i]);
                    rez[1] = i;
                }
            }
            else {
                if (Integer.parseInt(array[i]) < rez[2]) {
                    rez[2] = Integer.parseInt(array[i]);
                    rez[3] = i;
                }
            }
        }
        return rez;
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
