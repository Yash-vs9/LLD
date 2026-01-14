import java.util.Scanner;

public class Calculator {
    public static int multiply(int a, int b) {
        return a*b;
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static int sub(int a, int b) {
        return a-b;
    }

    public static int div(int a, int b) {
        int ans = Integer.MAX_VALUE;
        try {
            ans = a / b;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean user = true;
        Scanner sc = new Scanner(System.in);

        while (user) {
            System.out.println("CALCULATOR FOR INTEGERS");
            System.out.println("----------");
            System.out.println("a) For Addition press 1");
            System.out.println("b) For Subtraction press 2");
            System.out.println("c) For Multiplication press 3");
            System.out.println("d) For Division press 4");
            System.out.print("Enter your choice: ");

            int input = sc.nextInt();

            if (input == 1) {
                System.out.println("You chose addition");
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                int result = add(a, b);
                System.out.println("Result = " + result);
            } else if (input == 2) {
                System.out.println("You chose subtraction");
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                int result = sub(a, b);
                System.out.println("Result = " + result);
            } else if (input == 3) {
                System.out.println("You chose multiplication");
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                int result = multiply(a, b);
                System.out.println("Result = " + result);
            } else if (input == 4) {
                System.out.println("You chose division");
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                int result = div(a, b);
                if(result==Integer.MAX_VALUE){
                    System.out.println("NOT DEFINED");
                }
                else{
                    System.out.println("Result = " + result);

                }
            } else {
                System.out.println("Invalid input. Pleas try again.");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = sc.next().toLowerCase();
            if (!choice.equals("yes")) {
                user = false;
            }
        }

        System.out.println("Calculator exited.");
        sc.close();
    }
}