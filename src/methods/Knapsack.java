package methods;

import java.util.Arrays;

public class Knapsack {
    private final int[] weights;
    private final int[] costs;
    private final int needed;

    private int[][] results;

    public Knapsack(int[] weights, int[] costs, int needed) {
        this.weights = weights;
        this.costs = costs;
        this.needed = needed;
    }

    public void calculate() {
        int n = weights.length;
        results = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weights[j - 1] <= w) {
                    results[w][j] = Math.max(results[w][j - 1], results[w - weights[j - 1]][j - 1] + costs[j - 1]);
                } else {
                    results[w][j] = results[w][j - 1];
                }
            }
        }
    }

    @Override
    public String toString() {
        if (results == null) {
            return "Calculate method first!";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("Knapsack example:\n");
        for (int[] result : results) {
            builder.append("|\t");
            for (int i = 0; i < result.length - 1; i++) {
                builder.append(String.format("%-6d", result[i]));
            }
            builder.append(String.format("%-6d|\n", result[result.length - 1]));
        }
        int[] f = results[results.length - 1];
        builder.append("Answer:\n").append(f[f.length - 1]).append("\n");


        return builder.toString();
    }
}
