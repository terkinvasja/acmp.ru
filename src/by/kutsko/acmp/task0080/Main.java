package by.kutsko.acmp.task0080;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static String URL = System.getProperty("user.dir") + "/src/by/kutsko/acmp/task0080";

    public static void main(String[] args) throws IOException {


        Scanner dataFromFile = new Scanner(Paths.get(URL + "/input.txt"), "UTF-8");
//        Scanner dataFromFile = new Scanner(new File("input.txt"));

        PrintWriter printWriter = new PrintWriter(URL + "/output.txt", "UTF-8");
        //PrintWriter printWriter = new PrintWriter(new File("output.txt"));

        String data = "1";
        if (dataFromFile.hasNext()) {
            data = dataFromFile.nextLine().trim();
            dataFromFile.close();
        }

        String result = "";
        int state = 0;

        if (data.length() < 100 && data.length() > 0) {

            StringBuilder sbNumber1 = new StringBuilder();
            StringBuilder sbNumber2 = new StringBuilder();
            StringBuilder sbNumber3 = new StringBuilder();
            int number1 = 0;
            int number2 = 0;
            int number3 = 0;
            char znak = '.';

            for (int i = 0; i < data.length(); i++) {

                switch (state) {
                    case 0: {
                        if ((int) data.charAt(i) == 45) {
                            sbNumber1.append(data.charAt(i));
                            state = 1;
                        } else {
                            i--;
                            state = 1;
                        }
                        break;
                    }
                    case 1: {
                        if ((int) data.charAt(i) >= 48 && (int) data.charAt(i) <= 57) {
                            sbNumber1.append(data.charAt(i));
//                            System.out.println(String.format("%c = %d", data.charAt(i), (int) data.charAt(i)));
                        } else if (sbNumber1.length() == 0) {
                            state = 8;
                        } else {
                            number1 = Integer.valueOf(sbNumber1.toString());
                            state = 2;
                            i--;
//                            System.out.println(String.format("Number1 = %d, state = %d", number1, state));
                        }
                        if (i == data.length() - 1) result = "ERROR";
                        break;
                    }
                    case 2: {
                        if ((int) data.charAt(i) == 42 || (int) data.charAt(i) == 43
                                || (int) data.charAt(i) == 45 || (int) data.charAt(i) == 47) {
                            znak = data.charAt(i);
                            state = 3;
                        } else {
                            state = 8;
                        }
//                        System.out.println(String.format("%c = %d", data.charAt(i), (int) data.charAt(i)));
                        if (i == data.length() - 1) result = "ERROR";
                        break;
                    }
                    case 3: {
                        if ((int) data.charAt(i) == 45) {
                            sbNumber2.append(data.charAt(i));
                            state = 4;
                        } else {
                            i--;
                            state = 4;
                        }
                        break;
                    }
                    case 4: {
                        if ((int) data.charAt(i) >= 48 && (int) data.charAt(i) <= 57) {
                            sbNumber2.append(data.charAt(i));
//                            System.out.println(String.format("%c = %d", data.charAt(i), (int) data.charAt(i)));
                        } else if (sbNumber2.length() == 0) {
                            state = 8;
                        } else {
                            number2 = Integer.valueOf(sbNumber2.toString());
                            state = 5;
                            i--;
//                            System.out.println(String.format("Number2 = %d, state = %d", number2, state));
                        }
                        if (i == data.length() - 1) result = "ERROR";
                        break;
                    }
                    case 5: {
                        state = ((int) data.charAt(i) == 61) ? 6 : 8;
//                        System.out.println(String.format("%c = %d", data.charAt(i), (int) data.charAt(i)));
                        if (i == data.length() - 1) result = "ERROR";
                        break;
                    }
                    case 6: {
                        if ((int) data.charAt(i) == 45) {
                            sbNumber3.append(data.charAt(i));
                            state = 7;
                        } else {
                            i--;
                            state = 7;
                        }
                        break;
                    }
                    case 7: {
                        if ((int) data.charAt(i) >= 48 && (int) data.charAt(i) <= 57) {
                            sbNumber3.append(data.charAt(i));
//                            System.out.println(String.format("%c = %d", data.charAt(i), (int) data.charAt(i)));
                        } else if (sbNumber3.length() == 0) {
                            state = 8;
                        } else {
                            state = 8;
                        }
                        if (i == data.length() - 1) {
                            number3 = Integer.valueOf(sbNumber3.toString());
                            //state = 1;
                            //i--;
//                            System.out.println(String.format("Number3 = %d, state = %d", number3, state));
                        }
                        break;
                    }
                    case 8: {
                        result = "ERROR";
                        break;
                    }
                    default:
                }

//            System.out.println(String.format("state = %d", state));
            }

            if (!result.equals("ERROR")) {
                if ((int) znak == 43) {
                    result = (number1 + number2 == number3) ? "YES" : "NO";
                } else if ((int) znak == 45) {
                    result = (number1 - number2 == number3) ? "YES" : "NO";
                } else if ((int) znak == 42) {
                    result = (number1 * number2 == number3) ? "YES" : "NO";
                } else if ((int) znak == 47) {
                    if (number2 == 0) {
                        result = "NO";
                    } else result = (number1 / number2 == number3 && number1 % number2 == 0) ? "YES" : "NO";
                }
            }
        }

        System.out.println(result);
        printWriter.write(String.valueOf(result));
        printWriter.close();
    }


}
