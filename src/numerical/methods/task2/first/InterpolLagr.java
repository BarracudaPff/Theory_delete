package numerical.methods.task2.first;

import javafx.util.Pair;
import lib.com.polynom.polynom.Polynom;
import numerical.methods.task2.helpers.Function;

import static java.lang.Math.abs;

public class InterpolLagr {
    private static final double EPS = 0.001;
    private int n;
    private double a;

    private Function func;
    private Polynom interPol;
    private double[] points;


    public InterpolLagr(Function func, int n, double a) {
        this.func = func;
        this.n = n;
        this.a = a;
        points = new double[n];
        comPoints();
    }

    private void comPoints() {
        int j = 0;
        for (double i = -a; i <= a; i += 2 * a / (n - 1)) {
            //System.out.println("X: " + i + "; f(X): " + f(i));
            points[j] = i;
            j++;
        }
    }

    private Polynom l(int k) {
        Polynom res = new Polynom();
        for (int i = 0; i < n; i++) {
            if (i != k)
                res = res.multiply(fraction(k, i));
        }
        return res;
    }

    private Polynom fraction(int k, int i) {
        double[] numerator = new double[]{-points[i], 1};
        double denominator = 1 / (points[k] - points[i]);
        return new Polynom(numerator).multiply(denominator);
    }

    public Polynom com() {
        Polynom polynom = new Polynom("0");
        for (int i = 0; i < n; i++) {
            polynom = polynom.add(l(i).multiply(f(points[i])));
        }
        interPol = polynom;
        return polynom;
    }

    public Polynom comh() {
        Polynom polynom = new Polynom("0");
        for (int i = 0; i < n; i++) {
            polynom = polynom.add(l(i).multiply(hf(points[i])));
        }
        interPol = polynom;
        return polynom;
    }

    public Pair<Double, Double> maximumDeviation() {
        double max = Double.MIN_VALUE;
        double coord = 0;
        for (double i = -a; i <= a; i += EPS) {
            double point = abs(interPol.valueOf(i) - f(i));
            if (point > max) {
                max = point;
                coord = i;
            }
        }

        return new Pair<>(max, coord);
    }

    private double f(double x) {
        return func.f(x);
    }

    private double hf(double x) {
        return func.h(x);
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }
}
