import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Hashing {

    public static void main(String[] args) {


        HashSet<Integer> set = new HashSet<>();

        set.add(11);
        set.add(12);
        set.add(33);
        set.add(44);
        set.add(131);
        System.out.println(set);

        set.remove(131);

        if (set.contains(1)) {
            System.out.println(" contain 1");

        } else if (!set.contains(131)) {
            System.out.println("does not contains the number");

        }

    }


}
