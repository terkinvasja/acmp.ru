package by.kutsko.acmp.task0044;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 016 16.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0044";

    public static void main(String[] args) throws IOException {

        String arrow = ">>--><--<<";
        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        String data = "";
        if (dataFromFile.hasNext()) {
            data = dataFromFile.nextLine().trim();
            dataFromFile.close();
        }
        int result = 0;
        if (data.length() > 4 && data.length() <= 250) {
            for (int i = 0; i < data.length() - 4; i++) {
                if (data.substring(i, i + 5).equals(arrow.substring(0, 5)) || data.substring(i, i + 5).equals(arrow.substring(5, 10))) {
                    result++;
                }
            }
        }


        System.out.println(result);
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }
}
