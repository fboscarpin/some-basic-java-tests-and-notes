package new2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;

public class ArrayListsTest {

    public ArrayList createList(){
        ArrayList<String> listReturn = new ArrayList<>();
        listReturn.add("high-quality product");
        listReturn.add("user");
        listReturn.add("manager");
        return listReturn;
    }

    @Test
    public void createPrintList(){
        ArrayList<String> productslist = new ArrayList<String>();
        productslist.add("loan");
        productslist.add("card");
        productslist.add("salary account");
        productslist.add("point program");
        productslist.add(" ");
        System.out.println(productslist);
        System.out.println(productslist.size());

        // change value
        productslist.set(2, "nothing");
        System.out.println(productslist);

        // remove
        productslist.remove(4);
        System.out.println(productslist);

        // sorted
        Collections.sort(productslist);
        System.out.println("Sorted array list: \n"+productslist);

        // clear
        productslist.clear();
        if(productslist.isEmpty()) System.out.println("Is empty");
        System.out.println(productslist);

    }

    @Test
    public void printCollectionList(){

        ArrayList<String> newArrayList = createList();
        Integer indexControl = 0;

        for (String text:
                newArrayList) {
            System.out.println(text);
            if (indexControl==0) {
                //check last letter
                // we can also convert the string to array and access the array elements
                Integer lastLatterIndex = text.length() - 1;
                char c = text.charAt(lastLatterIndex);
                System.out.println("Last letter is: " + c);
                Assertions.assertEquals('t', c);
            }
            if(indexControl==1) {
                // check whole string
                Assertions.assertEquals("user", text);
            }
            if (indexControl==2) {
                //check first letter
                char c = text.charAt(0);
                Assertions.assertEquals('m', c); // don't forget that chart requires single quote
                System.out.println("First character is: " + c);
            }
            indexControl++;
        }
    }

}




