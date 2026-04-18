public class Exception extends Throwable {

    public void getData()  {


        try {
            int i=100;
            int j=0;
            int k=i/j;
            System.out.println(k);
        }
 catch (ArithmeticException e)
 {
     System.out.println("Error- exception");
 }

    }

}
