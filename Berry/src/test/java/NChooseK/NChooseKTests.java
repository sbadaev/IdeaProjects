package NChooseK;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NChooseKTests {

    @Test
    public void TestCalcCombos(){
        NChooseK nk = new NChooseK();
        long result = nk.calcCombos(5, 3);
        Assert.assertEquals("Expected n choose k answer for 5 choose 3", 10, result);
    }

    @Test
    public void TestGenCombos(){
        NChooseK nk = new NChooseK();
        List<String> result = nk.genCombos("ABCDE", 3);
        List<String> expected = Arrays.asList("ABC", "ABD", "ABE", "ACD", "ACE", "ADE", "BCD", "BCE", "BDE", "CDE");
        Assert.assertEquals(expected, result);
    }
}
