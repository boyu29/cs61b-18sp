import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Boyu Chen
 * @date 5/10/21
 */
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertFalse(offByN.equalChars('f', 'h'));
    }
}
