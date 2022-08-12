import java.util.Objects;

/**
 * TODO: Fill in the add and floor methods.
 */
public class AListFloorSet implements Lab5FloorSet {
    AList<Double> items;

    public AListFloorSet() {
        items = new AList<>();
    }

     public boolean contains(double elem) {
        for (double item : items) {
            if (item == elem) return true;
        }
        return false;
    }

    public void add(double x) {
        if (!contains(x)) {
            items.addLast(x);
        }

    }

    public double floor(double x) {
        if (contains(x)) return x;
        double result = Double.NEGATIVE_INFINITY;
        for (double item : items) {
            if (item < x && item > result) {result = item;}
        }
        return result;
    }
}
