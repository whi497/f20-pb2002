/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/11
 * @Description:
 * @Version: 1.0
 */
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestAListFloorSet {
    @Test
    public void test() {
        AListFloorSet AlSet = new AListFloorSet();
        Set<Double> aSet = new HashSet<>();
        for (int i = 0; i < 500; i++) {
            double test_data = StdRandom.uniform(-100, 100);
            AlSet.add(test_data);
            aSet.add(test_data);
        }
        for (int i = 0; i < 10000; i++) {
            double test_data = StdRandom.uniform(-500, 500);
            assertEquals(aSet.contains(test_data), AlSet.contains(test_data));
        }
    }
}
