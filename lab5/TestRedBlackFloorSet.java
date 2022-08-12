import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
       // TODO: YOUR CODE HERE
        RedBlackFloorSet RbSet = new RedBlackFloorSet();
        AListFloorSet AlSet = new AListFloorSet();
        for (int i = 0; i < 100000; i++) {
            double random_data = StdRandom.uniform(-5000.0, 5000.0);
            RbSet.add(random_data);
            AlSet.add(random_data);
        }
        for (int i = 0; i < 100000; i++) {
            double random_data = StdRandom.uniform(-5000.0, 5000.0);
            assertEquals(AlSet.floor(random_data), RbSet.floor(random_data), 0.00001);
        }
    }
}
