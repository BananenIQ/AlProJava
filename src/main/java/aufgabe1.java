import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class aufgabe1 {
    public static void main(String[] args) {

//        System.out.println(concat(new String[]{"Hallo", "Ich", "bin", "ein", "array"}));

        Kurs alpro = new Kurs("AlPro 3", "1222578",1);
        Kurs luds = new Kurs("LudS 1", "1223424",2);
        Kurs ti = new Kurs("TI 1", "7878787",3);
        Kurs sec = new Kurs("Sec 2", "789896787",1);


        Studi krystian = new Studi("Krystian", 20, "345");
        Studi felix = new Studi("Felix", 19, "435");
        Studi peter = new Studi("Peter", 22, "123");
        Studi leon = new Studi("Leon", 35, "4323");

        krystian.einschreiben(new Kurs[]{alpro ,luds ,ti});
        felix.einschreiben(new Kurs[]{alpro ,luds ,ti});
        peter.einschreiben(new Kurs[]{alpro ,luds ,ti});
        leon.einschreiben(new Kurs[]{alpro ,luds ,ti, sec});


        krystian.print();
        felix.print();
        peter.print();
        leon.print();

        calculator();
        askFib();
        askSum();
        String test = concat(new String[]{"TEST"});
        System.out.println(test);
    }

    public static String concat(String[] elements) {
        String concatText = "";
        for (int i = 0; i < elements.length; i++) {
            if (i + 1 == elements.length) {
                concatText = concatText.concat(elements[i]);
            } else {
                concatText = concatText.concat(elements[i] + " ");
            }
        }
        return concatText;
    }

    public static void askSum() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);
        ArrayList<Integer> list = new ArrayList<>();
        String userBufferInput;

        boolean isEntering = true;
        while (isEntering) {
            userBufferInput = input.nextLine();
            if (userBufferInput.contains("q!")) {
                isEntering = false;
                int[] sum = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    sum[i] = list.get(i);
                }
                System.out.println("Sum: " + sum(sum));
            } else {
                list.add(Integer.parseInt(userBufferInput));
            }
        }
        input.close();
    }

    public static int sum(int[] values) {
        int solution = 0;
        for (int value : values) {
            solution += value;
        }
        return solution;
    }

    public static void askFib() {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);
        System.out.println(fib(input.nextInt()));
        input.close();
    }

    public static long fib(int n) {
        if (n == 1 || n == 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

    public static void calculator() {
        double op1 = Double.parseDouble(ask("Enter a first digit -> usage: digit", true));
        double op2 = Double.parseDouble(ask("Enter a second digit -> usage: digit", true));
        String operator = ask("Specify an operator -> usage: + | - | * | / | %", false);
        System.out.println(op1 + " " + operator + " " + op2 + " = " + calculate(op1, op2, operator));
    }

    public static String ask(String question, boolean isNumeric) {
        String[] operators = {"+", "-", "*", "/", "%"};

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        String userInputBuffer;

        if (isNumeric) {
            boolean check;
            do {
                System.out.println(question);
                userInputBuffer = input.nextLine();

                check = true;
                try {
                    userInputBuffer = Double.parseDouble(userInputBuffer) + "";
                } catch (Exception NumberFormatException) {
                    System.out.println(question);
                    System.out.println("NUMBER PLS!!!!!");
                    userInputBuffer = input.nextLine();
                    check = false;
                }
            } while (!check);
        } else {
            boolean check;
            do {
                System.out.println(question);
                userInputBuffer = input.nextLine();

                check = false;
                for (String comp : operators) {
                    if (userInputBuffer.contains(comp)) {
                        check = true;
                        break;
                    }
                }
            } while (!check);
        }
        input.close();
        return userInputBuffer;
    }

    public static double calculate(double op1, double op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            case "%":
                return op1 % op2;
            default:
                return 0.0;
        }
    }
}
