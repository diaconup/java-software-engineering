package isp.lab2.Exercise4StringSearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param dap
     * @param substring what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] rezultat  = new String[2];
        String[] array = input.split(",");
        int i = 0;
        for(String string : array) {
            if(string.contains(substring)) {
                rezultat[i++] = string;
            }
        }
        return rezultat;
    }

    public static String readFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = "apples,computer,bread,tea,car";
        String substring = "te";
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
