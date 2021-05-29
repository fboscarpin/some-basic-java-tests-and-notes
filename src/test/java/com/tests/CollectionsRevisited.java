package com.tests;

import com.support.User;
import com.support.UserComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionsRevisited {

    @Test
    public void sortedSetCanMaintainSortOrder(){

        SortedSet<String> alphaset = new <String>TreeSet();
        alphaset.add("b");
        alphaset.add("d");
        alphaset.add("a");
        alphaset.add("a");
        alphaset.add("c");

        // the duplicates are removed,so only 4 elements are present
        Assertions.assertEquals(4, alphaset.size());

        // we can convert the SortedSet to an Array and access the elements on the proper order
        String[] arrayOne = new String[alphaset.size()];
        alphaset.toArray(arrayOne);
        Assertions.assertEquals("b", arrayOne[1]);

        // the elements are always sorted, even when we add/remove elements on a random way
        Assertions.assertEquals("a", alphaset.first());
        Assertions.assertEquals("d", alphaset.last());
    }

    @Test
    public void sortedSetWithHeadSetTailSet(){

        SortedSet<String> alphaset = new <String>TreeSet();
        alphaset.add("b");
        alphaset.add("a");
        alphaset.add("d");
        alphaset.add("c");

        // headSet() will create a subset that includes all elements before the argument

        SortedSet<String> subSet = alphaset.headSet("c");
        Assertions.assertEquals(2, subSet.size());

        String[] arrayOne = new String[subSet.size()];
        subSet.toArray(arrayOne);
        Assertions.assertEquals("a", arrayOne[0]);
        Assertions.assertEquals("b", arrayOne[1]);

        // tailSet() will create a subset that includes the argument and all the elements after the argument

        SortedSet<String> subSetTwo = alphaset.tailSet("c");
        Assertions.assertEquals(2, subSetTwo.size());

        String[] arrayTwo = new String[subSetTwo.size()];
        subSetTwo.toArray(arrayTwo);
        Assertions.assertEquals("c", arrayTwo[0]);
        Assertions.assertEquals("d", arrayTwo[1]);
    }

    @Test
    public void SortedSetWithSubSet(){

        SortedSet<String> alphaset = new <String>TreeSet();
        alphaset.add("house");
        alphaset.add("oats");
        alphaset.add("apple");
        alphaset.add("rain");

        // subSet() create a subset with the first argument and all the elements before the second argument

        SortedSet<String> subSet = alphaset.subSet("house", "rain");
        Assertions.assertEquals(2, subSet.size());

        String[] array = new String[subSet.size()];
        subSet.toArray(array);

        Assertions.assertEquals("house", array[0]);
        Assertions.assertEquals("oats" , array[1]);
    }

    @Test
    public void SortedSetWithcomparator(){

        // first, let's create some users (type user). The comparison will be based on the total length (username + password)

        User fabio = new User("fbouser", "pass"); // 11 (3dr)
        User amanda = new User("amanda", "1"); // 7 (1st)
        User bol = new User("bol", "Songs"); // 8 (2nd)
        User malani = new User("malani", "mypassword123"); // 19 (4th)

        // the TreeSet() would by default use its comparator method, but it would throw an error since the type 'User' is not implemented there.
        // the solution to work with objects is to implement our own method to compare them
        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator());

        userSortedList.add(fabio);
        userSortedList.add(amanda);
        userSortedList.add(bol);
        userSortedList.add(malani);

        User[] arrayUsers = new User[userSortedList.size()];
        userSortedList.toArray(arrayUsers);

        // the user object amanda is in the position index 1
        Assertions.assertEquals(amanda, arrayUsers[0]);

        // and we can also compare the values
        Assertions.assertEquals(amanda.getUsername(),arrayUsers[0].getUsername());
        Assertions.assertEquals(bol.getPassword(), arrayUsers[1].getPassword());
    }

}
