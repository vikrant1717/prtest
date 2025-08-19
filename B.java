import org.testng.annotations.Test;

public class B {


    @Test(groups={"High"})
    public void sum() {

        System.out.println("sum of two");

    }


    @Test(groups={"Low"})
    public void sub() {

        System.out.println("sub of two");

    }
}
