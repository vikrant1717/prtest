
import java.util.*;

public class Hashmap {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("india", 120);
        map.put("Australia", 22);
        map.put("pak", 12);
        map.put("china", 120);
        map.put("india", 140);

        /*if(map.containsKey("India"))
        {
            System.out.println("key is present");

        }else {

            System.out.println("key is not 2023.2.5 present");
        }
*/
        System.out.println(map.get("india"));
        System.out.println(map.get("lanka"));


        //    System.out.println(map);


        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }


    }
}
