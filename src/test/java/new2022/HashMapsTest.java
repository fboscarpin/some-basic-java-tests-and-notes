package new2022;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMapsTest {

    @Test
    public void createHasMap(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(01, "Apartment");
        map.put(02, "House");
        map.put(03, "Hotel");
        map.put(04, "Apart-Hotel");
        map.put(05, "Parent's house");
        System.out.println(map);
        map.forEach((k, v) -> System.out.println("Key:"+k + " / Value:"+v));
    }
}
