/**
 * @author Boyu Chen
 * @date 5/10/21
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStuExp(){
        StudentArrayDeque<Integer> stuDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expDeque = new ArrayDequeSolution<>();
        String failureExpresssion = "";

        for (int i = 0; i < 30; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne > 0.75) {
                stuDeque.addFirst(i);
                expDeque.addFirst(i);
                failureExpresssion = failureExpresssion + "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.5) {
                stuDeque.addLast(i);
                expDeque.addLast(i);
                failureExpresssion = failureExpresssion + "addLast(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.25) {
                if (!stuDeque.isEmpty() && !expDeque.isEmpty()) {
                    Integer stuRmFirst = stuDeque.removeFirst();
                    Integer expRmFirst = expDeque.removeFirst();
                    failureExpresssion = failureExpresssion + "removeFirst()";
                    assertEquals(failureExpresssion, expRmFirst, stuRmFirst);
                }
            } else {
                if (!stuDeque.isEmpty() && !expDeque.isEmpty()) {
                    Integer stuRmLast = stuDeque.removeLast();
                    Integer expRmLast = expDeque.removeLast();
                    failureExpresssion = failureExpresssion + "removeLast()";
                    assertEquals(failureExpresssion, expRmLast, stuRmLast);
                }
            }
        }
    }


}
