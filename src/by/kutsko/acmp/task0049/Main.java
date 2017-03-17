package by.kutsko.acmp.task0049;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 016 16.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0049";

    public static void main(String[] args) throws IOException {


        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        String data1 = dataFromFile.nextLine().trim();
        String data2 = dataFromFile.nextLine().trim();

        dataFromFile.close();

        StringBuilder sbMin = new StringBuilder();
        StringBuilder sbMax = new StringBuilder();

        int result = 1;

        int i = 0;
        while (i < data1.length()) {
            int[] d1 = minMax(data1.charAt(i));
            int[] d2 = minMax(data2.charAt(i));
            int min = 0;
            int max = 0;
            min = (d1[0] < d2[0]) ? Integer.valueOf(d2[0]) : Integer.valueOf(d1[0]);
            max = (d1[1] < d2[1]) ? Integer.valueOf(d1[1]) : Integer.valueOf(d2[1]);
/*            if (d1[0] < d2[0]) {
                sbMin.append(d2[0]);
            } else {
                sbMin.append(d1[0]);
            }
            if (d1[1] < d2[1]) {
                sbMax.append(d1[1]);
            } else {
                sbMax.append(d2[1]);
            }*/
/*            System.out.println("min = " + min);
            System.out.println("max = " + max);*/

            if (min <= max) {
                result = result * (max - min + 1);
            } else result = 0;

            i++;
        }


        System.out.println(result);
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }

    private static int[] minMax (Character s) {
//        System.out.println("s = " + s);
        int min = 0;
        int max = 0;
            if (s.equals('a')) {
                min = 0;
                max = 3;
            } else if (s.equals('b')) {
                min = 1;
                max = 4;
            } else if (s.equals('c')) {
                min = 2;
                max = 5;
            } else if (s.equals('d')) {
                min = 3;
                max = 6;
            } else if (s.equals('e')) {
                min = 4;
                max = 7;
            } else if (s.equals('f')) {
                min = 5;
                max = 8;
            } else if (s.equals('g')) {
                min = 6;
                max = 9;
            } else if (s.equals('?')) {
                min = 0;
                max = 9;
            } else {
                int i = Integer.valueOf(s.toString());
                min = i;
                max = i;
            }
//        System.out.println(min + ", " + max);

        return new int[] {min, max};
    }
}
