import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    int s = 9119;

//   public Reader() {
//        System.out.println("constructor is created");
//
//        System.out.println("start chrome browser");
//
//
//
//
//    public Reader(int x, int y) {
//        int z = x + y;
//        System.out.println(z);
//    }
//
//    public Reader(int x, int y, int z) {
//        int h = x + y + z;
//        System.out.println(h);
//        System.out.println("stop the browser");
//    }


    public void fileRead() throws IOException {

        String filepath = "/Users/vikrantphadtare/Documents/sample.txt";
        File fileobject = new File(filepath);
        FileReader filereader = new FileReader(fileobject);

        // List<String> List = Files.readAllLines(Paths.get(""));
        BufferedReader buffer = new BufferedReader(filereader);
        String s = buffer.readLine();
        while (s != null) {
            System.out.println(s);
            s = buffer.readLine();

        }
    }

    public int printData(int a, int b) {


        int k = a + b;

        System.out.println(k);

        return k;


    }

    public static int alpha(int h, int j) {

        int yu = h * j;

        System.out.println("this is static block");

        System.out.println(yu);
        return 0;
    }


    public int sub11() {

        System.out.println("this is learning java method calling");

        return 1111111;
    }

}
