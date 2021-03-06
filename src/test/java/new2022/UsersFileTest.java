package new2022;

import org.junit.jupiter.api.Test;
import supportMethods.SupportFilesUsers;

public class UsersFileTest {

    @Test
    public void printUsers(){

        // What this test does: get users from a csv file and print them
        SupportFilesUsers support = new SupportFilesUsers(); // needs to instantiate because my method is not static
        support.returnUsersCSV(2);
        String [] users = support.returnUsersCSV(2);
        System.out.println("User: " + users[0].trim());
        System.out.println("Password: " + users[1].trim());
    }
}
