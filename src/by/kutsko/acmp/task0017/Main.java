package by.kutsko.acmp.task0017;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by vasily on 17.03.2017.
 */
public class Main {

    public static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0017";

    public static void main(String[] args) throws IOException {

        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        int size = Integer.valueOf(dataFromFile.nextLine().trim());

        String initialData = dataFromFile.nextLine().trim();
        int indexFirstSpace = initialData.indexOf(" ");
//            System.out.println("indexFirstSpace = " + indexFirstSpace);
        String data = initialData.substring(0, initialData.length() - indexFirstSpace - 1);
//            System.out.println("data = " + data);
        dataFromFile.close();

        StringBuilder sb = new StringBuilder();
        sb.append(data);
        sb.append(" ");
        sb.append(data);

        sb.delete(0, indexFirstSpace);

        int pos1 = kmpMatcher(sb.toString(), data);
//        System.out.println(pos1);
        String str = sb.toString().substring(0, pos1);
        int result = str.length() - str.replaceAll(" ", "").length();

        System.out.println(result);
//        System.out.println(sb.toString().substring(pos1, pos1 + data.length()));
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }

    public static int kmpMatcher(String s, String pattern) {
        int m = pattern.length();
        if (m == 0)
            return 0;
        int[] p = prefixFunction(pattern);
        for (int i = 0, k = 0; i < s.length(); i++)
            for (; ; k = p[k - 1]) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    if (++k == m)
                        return i + 1 - m;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }
}
