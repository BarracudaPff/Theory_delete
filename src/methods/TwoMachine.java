package methods;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class TwoMachine {
    private final ArrayList<Pair<Integer,Pair<Integer, Integer>>> times;

    private int[] results;

    public TwoMachine(int[] firstTimes, int[] secondTimes) {
        times = new ArrayList<>();

        for (int i = 0; i < firstTimes.length; i++) {
            times.add(new Pair<>(i, new Pair<>(firstTimes[i], secondTimes[i])));
        }
    }

    public int[] calculate() {
        results = new int[times.size()];
        int start = 0, end = results.length - 1;

        sort();

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getValue().getKey() < times.get(i).getValue().getValue()) {
                results[start] = times.get(i).getKey();
                start++;
            } else {
                results[end] = times.get(i).getKey();
                end--;
            }
        }

        return results;
    }

    /**
     * Сначала сравнивает значение Value, если Value одинаковы, то сравнивает по Key
     */
    private void sort() {
        times.sort((o1, o2) -> {
            int result = Integer.compare(o1.getValue().getValue(), o2.getValue().getValue());
            if (result != 0) {
                return result;
            }
            return Integer.compare(o1.getValue().getKey(), o2.getValue().getKey());
        });
    }

    @Override
    public String toString() {
        if (results == null) {
            return "Calculate method first!";
        }
        StringBuilder builder = new StringBuilder();

        builder.append("TwoMachine example:\n|  ");
        for (int i = 0; i < results.length - 1; i++) {
            builder.append(String.format("%-3d", results[i]));
        }
        builder.append(String.format("%-3d|\n", results[results.length - 1]));
        return builder.toString();
    }
}
