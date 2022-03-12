package new2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrderArray {

    @Test
    public void orderWordsArray(){

        // get the text from a file
        String text = supportMethods.supportFiles.returnTextFile("src/main/java/supportMethods/products.txt");
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
        String text = supportMethods.supportFiles.returnTextFile("src/main/java/supportMethods/products.txt");
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


    }

}
