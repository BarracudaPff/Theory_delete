package numerical.methods.task2.first;

import javafx.util.Pair;
import lib.com.polynom.polynom.Polynom;
import numerical.methods.task2.helpers.*;

import java.util.Arrays;

import static java.lang.Math.abs;

public class InterpolErm {
    private static final double EPS = 0.001;
    private final int n;
    private double a;

    private Function func;
    private double[] points;
    private Polynom interPol;

    private Polynom P_N_0;
    private Polynom P_N_2;

    public InterpolErm(Function func, double a, int n) {
        this.func = func;
        this.a = a;
        this.n = n;
        points = new double[n];
        comPoints();
    }

    private void comPoints() {
        int j = 0;
        for (double i = -a; i <= a; i += 2 * a / (n - 1)) {
            points[j] = i;
            j++;
        }
        /*double[] resa = new double[n];
        for (int i = 0; i < points.length; i++) {
            resa[i] = f(points[i]);
        }
        double[] resd = new double[n];
        for (int i = 0; i < points.length; i++) {
            resd[i] = df(points[i]);
        }
        System.out.println(Arrays.toString(points));
        System.out.println(Arrays.toString(resa));
        System.out.println(Arrays.toString(resd));*/
    }

    public InterpolErm setPoints(double[] points) {
        this.points = points;
        return this;
    }

    private Polynom omega(int n) {
        Polynom polynom = new Polynom();
        for (int i = 0; i < (n - 1); i++) {
            polynom = polynom.multiply(new Polynom(new double[]{-points[i], 1}));
        }
        return polynom;
    }

    public Polynom com() {
        InterpolLagr interpolLagr = new InterpolLagr(func, n, a);
        interpolLagr.setPoints(points);
        P_N_0 = interpolLagr.com();

        Function3Point ex2 = new Function3Point()
                .setX(points)
                .setY(comNewPoints());
        InterpolLagr interpolLagr2 = new InterpolLagr(ex2, n, a);
        interpolLagr2.setPoints(points);
        P_N_2 = interpolLagr2.com();

        Polynom q = omega(n+1).multiply(P_N_2);
        interPol = P_N_0.add(q);
        return interPol;
    }

    public Polynom com2() {
        InterpolLagr interpolLagr = new InterpolLagr(func, n, a);
        interpolLagr.setPoints(points);
        P_N_0 = interpolLagr.com();

        Function3Point ex2 = new Function3Point()
                .setX(points)
                .setY(comNewPoints());
        InterpolLagr interpolLagr2 = new InterpolLagr(ex2, n, a);
        interpolLagr2.setPoints(points);
        P_N_2 = interpolLagr2.com();

        return interPol;
    }

    private double[] comNewPoints() {
        double[] res = new double[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = P(points[i]);
        }
        return res;
    }

    private double P(double x) {
        return (df(x) - P_N_0.differentiate().valueOf(x)) / (omega(n + 1).differentiate()).valueOf(x);
    }

    private double dP(double x) {
        return 0;// (df(x) - P_N_0.differentiate().valueOf(x)) / omega(n + 1).differentiate().valueOf(x);
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

    private double f(double i) {
        return func.f(i);
    }

    private double df(double x) {
        return func.df(x);
    }

    public double[] getPoints() {
        return points;
    }
}
