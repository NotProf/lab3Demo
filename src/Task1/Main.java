package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String action;
        double first, second, result;
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerDouble = new Scanner(System.in);

        System.out.println("First");
        first = scannerDouble.nextDouble();
        System.out.println("Second");
        second = scannerDouble.nextDouble();
        System.out.println("Action");
        action = scannerString.nextLine();

        try {
            result = calculate(first, second, action);
            System.out.println("Result  - " + result);
        } catch (ZeroException e) {
            System.out.println(e.getMessage() + e.getCode());
        }
    }

    public static double calculate(double first, double second, String action) throws ZeroException {
        double result = 0;
        if (action.equals("*")) {
            result = first * second;
        } else if (action.equals("/")) {
            if (second == 0) {
                throw new ZeroException("Div by zero exception with code - ", 1);
            } else {
                result = first / second;
            }
        } else if (action.equals("+")) {
            result = first + second;
        } else if (action.equals("-")) {
            result = first - second;
        } else {
            System.out.println("Action not found");
        }
        return result;
    }
}
