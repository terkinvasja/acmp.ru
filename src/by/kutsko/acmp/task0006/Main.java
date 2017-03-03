package by.kutsko.acmp.task0006;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Vasili on 002 02.03.17.
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

        int pos = strFromFile.indexOf('-');

        if (pos == 2 && strFromFile.length() == 5) {
            String start = strFromFile.substring(0, pos);
            String end = strFromFile.substring(pos + 1, strFromFile.length());

            String[] arrayField = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};

            int startIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < 8; i++){
                if (arrayField[i].equalsIgnoreCase(start.substring(0,1))) {
                    startIndex = i + 1;
                }
                if (arrayField[i].equalsIgnoreCase(end.substring(0,1))) {
                    endIndex = i + 1;
                }
            }

            int x = Integer.valueOf(start.substring(1,2));
            int y = Integer.valueOf(end.substring(1,2));

            System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);

            if (startIndex == 0 || endIndex == 0 || x > 8 || x < 1 || y > 8 || y < 1) {
                sb.append("ERROR");
            } else {
                if ( (Math.abs(startIndex - endIndex) * Math.abs(x - y)) == 2 ) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
            }
        } else {
            sb.append("ERROR");
        }

        System.out.println(sb.toString());

        printWriter.write(sb.toString());
        printWriter.close();
    }
}
