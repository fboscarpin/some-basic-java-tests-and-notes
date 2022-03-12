package supportMethods;

import java.util.Comparator;

public class UserComparator implements Comparator {

    public int compare (Object oUser1, Object oUser2){

        User user1 = (User)oUser1;
        User user2 = (User)oUser2;

        // we will compare the object user by the total text length (password + username):

        int user1comparator = user1.getUsername().length() + user1.getPassword().length();
        int user2comparator = user2.getUsername().length() + user2.getPassword().length();

        int val = user1comparator - user2comparator;

        // if they are the same (no difference), the we use the username to differentiate them
        if(val==0) val = user1.getUsername().compareTo(user2.getUsername());

        return val;
    }
}
