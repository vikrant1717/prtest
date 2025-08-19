
import org.testng.annotations.*;

public class A {

    @BeforeMethod()
    public void startBrowser() {
        System.out.println("start browser and login");
    }

    @Test(invocationCount = 2)
    public void print() {
        System.out.println("hello world first");
    }

    @Test(priority = 3)
    public void print1() {
        System.out.println("hello world 3");
    }

    @Test(priority = 2)
    public void aaa() {

        System.out.println("this will be called first 2");
    }

    @Test(priority = 1)
    public void collect() {
        System.out.println("set as 1");
    }

    @AfterMethod
    public void stopbrowser() {

        System.out.println("close the browser");
    }
}
