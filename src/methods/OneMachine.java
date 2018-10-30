package methods;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class OneMachine {

    private final int[] times;
    private final int[] priorities;
    private final ArrayList<Pair<Integer, Double>> array;

    private int[] results;

    public OneMachine(int[] times, int[] priorities) {
        this.times = times;
        this.priorities = priorities;

        array = new ArrayList<>();
    }

    public void calculate() {
        for (int i = 0; i < times.length; i++) {
            array.add(new Pair<>(i, (double) priorities[i] / times[i]));
        }
        array.sort(Comparator.comparingDouble(Pair::getValue));
        results = new int[array.size()];

        for (int i = 0; i < results.length; i++) {
            results[i] = array.get(i).getKey();
        }
    }

    @Override
    public String toString() {
        if (results == null) {
            return "Calculate method first!";
        }
        StringBuilder builder = new StringBuilder();

        builder.append("OneMachine example:\n|  ");
        for (int i = 0; i < results.length - 1; i++) {
            builder.append(String.format("%-3d", results[i]));
        }
        builder.append(String.format("%-3d|\n", results[results.length - 1]));
        return builder.toString();

    }
}
