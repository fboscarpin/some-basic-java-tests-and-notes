package new2022;

import org.junit.jupiter.api.Test;
import supportMethods.SupportFilesUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysTest {

    @Test
    public void orderWordsArray(){

        // get the text from a file
        String text = SupportFilesUsers.returnTextFile("src/main/java/supportMethods/products.txt");
        System.out.println("Raw text:"+ text);

        // convert to array
        System.out.println("\n Array:");
        String[] myArray = text.split(" ");
        for (String item:
                myArray) {
            System.out.println(item);
        }

        // sort array content

        System.out.println("\n Sorted Array:");
        Arrays.sort(myArray);
        for (String item:
             myArray) {
            System.out.println(item);
        }
    }

    @Test
    public void orderWordsArrayList(){

        // get the text from a file
        String text = SupportFilesUsers.returnTextFile("src/main/java/supportMethods/products.txt");
        System.out.println("Raw text:"+ text);

        // convert to array list
        System.out.println("\n Array List:");
        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(text.split(" ")));

        for (String item:
             myList) {
            System.out.println(item);
        }

        // sort array list

        System.out.println("\n Sorted Array List:");
        Collections.sort(myList);
        for (String item:
             myList) {
            System.out.println(item);
        }

        // convert to string

        String converted = myList.toString();
        System.out.println("Converted to string: "+ converted);
    }

    @Test
    public void sumIntArray(){
        List<Integer> myarray = new ArrayList<>(Arrays.asList(1,5,7,8));
        Integer sum = 0;
        for (Integer item : myarray){
            sum  = item + sum;
        }
        System.out.println(sum);
    }


}
