package by.kutsko.acmp.task0005;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 002 02.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0005";

    public static void main(String[] args) throws IOException {

        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
        //Scanner dataFromFile = new Scanner(new File("input.txt"));

        /*int n = Integer.valueOf(inFileStream.readLine());
        String[] arrayNumbersStr = inFileStream.readLine().split(" ");
        inFileStream.close();*/
        int n = Integer.valueOf(dataFromFile.nextLine());
        String[] arrayNumbersStr = dataFromFile.nextLine().split(" ");
        dataFromFile.close();

        int[] arrayOddDays = new int[n];
        int[] arrayEvenDays = new int[n];
        int oddDays = 0;
        int evenDays = 0;

        for(int i = 0; i < arrayNumbersStr.length; i++) {
            int day = Integer.valueOf(arrayNumbersStr[i]);
            if (day % 2 == 0) {
                arrayEvenDays[evenDays] = day;
                evenDays++;
            } else {
                arrayOddDays[oddDays] = day;
                oddDays++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < oddDays; i++) {
            sb.append(arrayOddDays[i]);
            sb.append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < evenDays; i++) {
            sb.append(arrayEvenDays[i]);
            sb.append(" ");
        }
        sb.append("\n");

        if (evenDays >= oddDays) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));
        printWriter.write(sb.toString());
        printWriter.close();

    }
}
