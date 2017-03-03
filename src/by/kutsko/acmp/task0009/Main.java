package by.kutsko.acmp.task0009;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 003 03.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0009";

    public static void main(String[] args) throws IOException {

        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
        //Scanner dataFromFile = new Scanner(new File("input.txt"));
        //Scanner dataFromFile = new Scanner(System.in);

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));
        //PrintWriter printWriter = new PrintWriter(System.out);

        int size = dataFromFile.nextInt();
        int[] arrayNumbers = new int[size];

        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = dataFromFile.nextInt();
        }
        dataFromFile.close();

        int min = arrayNumbers[0];
        int max = arrayNumbers[0];
        int indexMin = 0;
        int indexMax = 0;
        int sum = 0;

        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] > 0) sum = sum + arrayNumbers[i];

            if (arrayNumbers[i] < min) {
                min = arrayNumbers[i];
                indexMin = i;
            }
            if (max < arrayNumbers[i]) {
                max = arrayNumbers[i];
                indexMax = i;
            }
        }

        int start = 0;
        int end = 0;

        if (indexMin < indexMax) {
            start = indexMin;
            end = indexMax;
        } else {
            start = indexMax;
            end = indexMin;
        }

        int op = 1;

        for (int i = start + 1; i < end; i++) {
            op = op * arrayNumbers[i];
        }

        System.out.println("summa: " + sum);
        System.out.println("op: " + op);
        System.out.println("indexMin: " + indexMin + ", min: " + min + "; indexMax: " + indexMax + ", max: " + max);

        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        sb.append(" ");
        sb.append(op);

        printWriter.write(sb.toString());
        printWriter.close();
    }
}
