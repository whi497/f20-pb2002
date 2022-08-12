import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.print("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        List<Integer> Ns = new ArrayList<>(
                Arrays.asList(1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000));
        List<Double> times = new ArrayList<>();
        List<Integer> opCounts = new ArrayList<>(
                Arrays.asList(10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000));
        for (int n : Ns) {
            SLList<Integer> list = new SLList<>();
            for (int i = 0; i < n; i++) {list.addLast(10);}
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < 10000; i += 1) {list.getLast();}
            times.add(sw.elapsedTime());
        }
        printTimingTable(Ns, times, opCounts);
    }

}
