package isp.lab2.Exercise6WordGuess;

import java.util.Scanner;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     * @param c
     * @param word
     * @return
     */
    public static int countOccurence(char c, char[] word) {
        int nrExist = 0;
        for(int i = 0; i < word.length; i++) {
            if(word[i] == c)
                nrExist++;
        }
        return nrExist;
    }

    public static boolean done(boolean[] array) {
        for(int i = 0; i < array.length; i++)
            if(array[i] == false)
                return false;
        return true;
    }

    public static boolean mark(boolean[] array) {
        for(int i = 0; i < array.length; i++)
            if(array[i] == false)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // citirea unui șir de caractere de la consolă
        char[] word = {'m', 'a', 's', 'i', 'n', 'a'};
        boolean[] checked = {false, false, false, false, false, false};
        char[] correct;
        while(!done(checked)) {
            System.out.print("Introduceti un caracter:");
            char letter = scanner.next().charAt(0);

        }
    }

}
