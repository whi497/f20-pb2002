/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/8
 * @Description:
 * @Version: 1.0
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private final Integer Test_Scale = 10;

    @Test
    public void autograde_array() {
        StudentArrayDeque<Integer> student_array = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> solution_array = new ArrayDequeSolution<Integer>();
        Integer randomnumber;
        String msg;
        Integer expected;
        Integer actual;
        for (int i = 0; i < Test_Scale/2; i++) {
            randomnumber = StdRandom.uniform(100);
            student_array.addFirst(randomnumber);
            solution_array.addFirst(randomnumber);
            expected = solution_array.getFirst();
            actual = student_array.get(0);
            msg = "Wrong when execute addFirst method\n Expected: " + expected + "\n" +"Actual: " + actual + "\n";
            assertEquals(msg, expected, actual);
        }
        for (int i = 0; i < Test_Scale/2; i++) {
            randomnumber = StdRandom.uniform(100);
            student_array.addLast(randomnumber);
            solution_array.addLast(randomnumber);
            expected = solution_array.getLast();
            actual = student_array.get(student_array.size() - 1);
            msg = "Wrong when execute addLast method\n Expected: " + expected + "\n" +"Actual: " + actual + "\n";
            assertEquals(msg, expected, actual);
        }
        for (int i = 0; i < Test_Scale; i++) {
            if (i%2 == 0) {
                expected = solution_array.removeLast();
                actual = student_array.removeLast();
                msg = "Wrong when execute removeLast() method\n Expected: " + expected + "\n Actual: " + actual + "\n";
            } else {
                expected = student_array.removeFirst();
                actual = student_array.removeFirst();
                msg = "Wrong when execute removeFirst() method\n Expected: " + expected + "\n Actual: " + actual + "\n";
            }
            assertEquals(msg, expected, actual);
        }
    }
}
