package by.kutsko.acmp.task0009;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 003 03.03.17.
 */
public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp";

    public static void main(String[] args) throws IOException {

        Scanner dataFromFile = new Scanner(Paths.get(URL + "/task0006/input.txt"), "UTF-8");
        //Scanner dataFromFile = new Scanner(new File("input.txt"));
        //Scanner dataFromFile = new Scanner(System.in);
        String strFromFile = dataFromFile.nextLine();
        dataFromFile.close();

        PrintWriter printWriter = new PrintWriter(URL + "/task0006/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));
        //PrintWriter printWriter = new PrintWriter(System.out);


        StringBuilder sb = new StringBuilder();










        printWriter.write(sb.toString());
        printWriter.close();
    }
}
