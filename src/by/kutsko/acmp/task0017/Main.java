package by.kutsko.acmp.task0017;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 016 16.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0017";

    public static void main(String[] args) throws IOException {

        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        int size = Integer.valueOf(dataFromFile.nextLine().trim());
        String data = dataFromFile.nextLine().trim().substring(0, (size * 2) - 3);

        dataFromFile.close();

        StringBuilder sb = new StringBuilder();
        sb.append(data);
        sb.append(" ");
        sb.append(data);

        String d = sb.substring(2);

        int result = d.indexOf(data)/2 + 1;

        System.out.println(result);
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }
}
