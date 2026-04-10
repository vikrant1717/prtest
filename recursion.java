import java.util.Scanner;

public class recursion {


    public static void ios(int a) {

        // System.out.println(a);
        for (int i = a; i >= 1; i--) {

            System.out.println(i);
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int n = sc.nextInt();
        ios(n);


    }
}
