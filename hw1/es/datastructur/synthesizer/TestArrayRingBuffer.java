package es.datastructur.synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(10);
        In in = new In("C:\\Users\\wh030917\\Desktop\\GitHub\\fa20-s2002\\hw1\\es\\datastructur\\synthesizer\\test.txt");
        assertEquals(10, arb.capacity());
        for (int i = 0; i < 10; i++) {
            arb.enqueue(in.readString());
            assertEquals(i+1, arb.fillCount());
        }
        assertTrue(arb.isFull());

        assertEquals("when", arb.peek());
        assertEquals("when", arb.dequeue());
        assertEquals("we", arb.dequeue());
        assertEquals("implement", arb.dequeue());

        assertEquals(7, arb.fillCount());

        for (int i = 0; i < 3; i++) {
            arb.enqueue(in.readString());
            assertEquals(i+8, arb.fillCount());
        }
        assertTrue(arb.isFull());

        assertEquals("class", arb.dequeue());
        assertEquals("inheritance", arb.dequeue());
    }
}
