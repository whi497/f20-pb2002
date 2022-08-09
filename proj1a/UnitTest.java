/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/5
 * @Description:
 * @Version: 1.0
 */
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Optional;

public class UnitTest {
    @Test
    public void testLinkPrint() {
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.printDeque();
    }
    @Test
    public void testArray() {//TODO: add more tests here
        ArrayDeque<Integer> list = new ArrayDeque<Integer>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.printDeque();
        assertEquals(3, list.size());
        list.removeFirst();
        assertNull(list.get(2));
        list.printDeque();
        for (int i = 0; i < 120; i++) {
            list.addLast(10);
        }
        assertEquals(122, list.size());
//        assertEquals(180, list.capacity);
        for (int i = 0; i < 80; i++) {
            list.removeLast();
        }
        assertEquals(42, list.size());
//        assertEquals(120, list.capacity);
        int test = list.get(0);
        assertEquals(2, test);
        test = list.get(1);
        assertEquals(1, test);
        test = list.get(41);
        assertEquals(10, test);
    }
}
