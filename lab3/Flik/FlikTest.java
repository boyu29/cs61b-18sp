/**
 * @author Boyu Chen
 * @date 5/9/21
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testFlik() {
        boolean result1 = Flik.isSameNumber(1,2);
        boolean exp1 = false;
        assertEquals(exp1, result1);

        boolean result2 = Flik.isSameNumber(129,129);
        assertTrue(result2);
    }
}
