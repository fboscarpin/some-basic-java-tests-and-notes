package new2022;

import org.junit.Assert;
import org.junit.Test;

public class StringsTest {

    @Test
    public void makeSomeAssertions(){
        String s = "We should test early and often";
        Assert.assertTrue(s.contains("sh"));
        Assert.assertTrue(s.startsWith("W"));
        Assert.assertTrue(s.endsWith("en"));
        Assert.assertFalse(s.isEmpty());
    }

}

