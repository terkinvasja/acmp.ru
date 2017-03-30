package by.kutsko.acmp.task0057;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 016 16.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0057";

    public static void main(String[] args) throws IOException {


        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        String[] data1 = dataFromFile.nextLine().trim().split(" ");
        short N = Short.valueOf(data1[0]);
        short c = Short.valueOf(data1[1]);
        long p = Long.valueOf(data1[2]);

        double t = 0;

        short[] xArrays = new short[N];
        short[] yArrays = new short[N];
        short xNet = 0;
        short yNet = 0;

        String result = "";

//        System.out.println(String.format("N = %d, c = %d, p = %d", N, c, p));

        for (int i = 0; i < N; i++) {
            String[] data2 = dataFromFile.nextLine().trim().split(" ");
            xArrays[i] = Short.valueOf(data2[0]);
            yArrays[i] = Short.valueOf(data2[1]);
//            System.out.println(String.format("xArrays[%d] = %d, yArrays[%d] = %d", i, xArrays[i], i, yArrays[i]));
        }

        String[] data3 = dataFromFile.nextLine().trim().split(" ");
        xNet = Short.valueOf(data3[0]);
        yNet = Short.valueOf(data3[1]);
//        System.out.println(String.format("xNet = %d, yNet = %d", xNet, yNet));

        dataFromFile.close();

        for (int i = 0; i < N; i++) {
            t = len(xArrays[i], yArrays[i], xNet, yNet);
            for (int j = 0; j < N; j++) {
                t = t + len(xArrays[i], yArrays[i], xArrays[j], yArrays[j]);
            }
//            System.out.println(t * c - p);
            if (t * c - p < 0.01) {
                result = "YES";
                break;
            } else {
                result = "NO";
            }
        }

//        System.out.println(result);
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }

    private static double len (short x1, short y1, short x2, short y2) {
        return Math.sqrt(Math.pow((double) (x2 - x1), 2) + Math.pow((double) (y2 - y1), 2));
    }

}
