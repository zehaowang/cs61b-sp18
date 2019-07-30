import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(2);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'c'));
        assertTrue(offByN.equalChars('c', 'a'));
        assertFalse(offByN.equalChars('a', 'a'));
    }

    /*Uncomment this class once you've created your CharacterComparator interface and OffByOne class. */
}
