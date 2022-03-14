package new2022;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneralTest {

    public Boolean isPrimeCheck(Integer n){

//        % is Modulus - it	Returns the division remainder	x % y

        boolean isPrime = true;
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) { // if division remainder is zero, it means that the number is divided by other number (besides 1 and itself)
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }


    public void secondLargestNumberArray(){




    }

    @Test
    public void LinearSearch(){

        // Write a method that returns the index of the first occurrence of given integer in a list.

        Integer array [] = {1, 0, 6, 5, 3, 00, 66, 23};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        Integer search = 5; // 5 is example
        Integer indexControl = 0;
        Boolean elementFound = false;

//        Option 1
//        for (Integer item:
//            list) {
//            if(item == 5) break;
//            indexControl++;
//        }
//        System.out.println("Index: "+ indexControl);

        // Option 2
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) == search) {
                System.out.println("Index: "+ i);
                elementFound = true;
                break;
            }
        }
        if(elementFound == false) System.out.println("Element was not found in the list");
    }

    public List<Integer> onlyList(){
        List<Integer> listReturn = new ArrayList<>();
        listReturn.add(1);
        listReturn.add(3);
        System.out.println("Print first position in the list: "+listReturn.get(0)); // print position 0
        return listReturn;
    }

    @Test
    public void findCounterBiggerElementList(){
        Integer array [] = {1, 2, 11, 4, 0, 11, 5, 6, 2};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list);
        Integer biggerValue = list.get(list.size()-1);
        Integer timesBigger = Collections.frequency(list, biggerValue);
        System.out.println(timesBigger); // how many times the bigger element appears in the list
    }


    @Test
    public void fibonacci(){

        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.add(0);
        myArray.add(1);
        Integer p1 = 0;
        Integer p2 = 1;
        Integer n;

        for (Integer i = 0; i<11; i++){
            n = p1+p2;
            myArray.add(n);
            p1 = p2;
            p2 = n;
        }

        String result = myArray.toString();
        System.out.println("Result: "+ result);
        Assert.assertEquals(result, "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]");
    }

    @Test
    public void checkTest(){
        System.out.println("List: "+onlyList());
        System.out.println(isPrimeCheck(20));
    }

}
