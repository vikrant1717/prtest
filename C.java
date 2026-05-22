import org.testng.Assert;
import org.testng.annotations.Test;

public class C {
    @Test
    public void thisisC() {
        System.out.println("C class method");
        //Assert.assertTrue(false);

        Assert.assertEquals("helloVikrant", "hello");
    }
}
