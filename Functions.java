import java.util.Scanner;

public class Functions {

    public static int multiplication(int a, int b) {

        int mul = a * b;
        return mul;
        
    }

    public static int add(int a, int b) {
        int sum12 = a + b;
        
 
        return sum12;


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number:");
        int a = sc.nextInt();
        // System.out.println();
        System.out.print("Enter Second number:");
        int b = sc.nextInt();
        //System.out.println();

        int mul = multiplication(a, b);
        System.out.print("multiplication of both numbers is:");
        System.out.println(mul);

        int c = sc.nextInt();
        int d = sc.nextInt();

        int sum1 = add(c, d);
        System.out.println(sum1);


    }


}


