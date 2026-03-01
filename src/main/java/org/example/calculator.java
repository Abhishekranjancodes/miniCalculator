package org.example;
import java.util.Scanner;

public class calculator {

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("\nError: Mujhe maaf kar dein ye nhi ho payega");
        }
        return a / b;
    }
    public static double squareRoot(double a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nJo aadesh ho maalik aapka!");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exit");
            System.out.print("Choose an operation: ");

            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 5) {
                if (choice == 5){
                    System.out.print("Number: ");
                    double num1 = scanner.nextDouble();
                }
                else {
                    System.out.print("First number: ");
                    double num1 = scanner.nextDouble();

                    System.out.print("Second number: ");
                    double num2 = scanner.nextDouble();
                }
                try {
                    double result = 0;

                    switch (choice) {
                        case 1:
                            result = addition(num1, num2);
                            break;
                        case 2:
                            result = subtraction(num1, num2);
                            break;
                        case 3:
                            result = multiplication(num1, num2);
                            break;
                        case 4:
                            result = division(num1, num2);
                            break;
                        case 5:
                            result = squareRoot(num1);
                            break;
                    }

                    System.out.println("\nAnswer: " + result);

                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 6) {
                System.out.println("Tata bye bye gya!");
            } else {
                System.out.println("Ye operation valid nhi hai,Kripya phir se koshish karein");
            }

        } while (choice != 6);

        scanner.close();
    }
}