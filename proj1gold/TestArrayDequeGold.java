import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> sad = new StudentArrayDeque();
    ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

    @Test
    public void test() {
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                sad.addLast(i);
                ads.addLast(i);
            } else if (numberBetweenZeroAndOne < 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
            } else if (numberBetweenZeroAndOne < 0.75) {
                sad.removeFirst();
                ads.removeFirst();
            } else {
                sad.removeLast();
                ads.removeLast();
            }
        }
        Integer expected = ads.removeFirst();
        Integer actual = sad.removeFirst();
        assertEquals(actual + " not equals to " + expected, expected, actual);
    }
}
