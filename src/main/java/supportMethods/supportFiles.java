package supportMethods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class supportFiles {

    // create a method to read file and return an user array

    public String[] returnUsersCSV(Integer userIndex){

        // read a specific line from the file, add it to an array, and then return it

        String [] userDetailsArray = null;

        try {
            FileReader myReader = new FileReader("src/main/java/supportMethods/data.csv");
            BufferedReader myBufferedReader = new BufferedReader(myReader);
            String lineContent  = myBufferedReader.lines().skip(userIndex).findFirst().get();
            userDetailsArray = lineContent.split(",");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the users. Error:\n");
            e.printStackTrace();
        }
        return userDetailsArray;
    }


}
