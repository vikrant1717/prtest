import java.util.Scanner;

public class factorial {

    public static void factorial(int a) {
        int fact = 1;
        if (a < 0) {

            System.out.println("number is negative");
            return;
        } else


            for (int i = a; i >= 1; i--) {

                fact = fact * i;
            }
        System.out.println(fact);

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to find a factorial:");
        int a = sc.nextInt();

        factorial(a);

    }


}


