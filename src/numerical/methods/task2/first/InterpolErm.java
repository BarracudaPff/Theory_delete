package numerical.methods.task2.first;

import lib.com.polynom.polynom.Polynom;
import numerical.methods.task2.helpers.*;

import java.util.Arrays;

public class InterpolErm {
    private static final double EPS = 0.001;
    private static final int n = 3;
    private double a;

    private Function func;
    private Polynom interPol;
    private double[] points;

    public InterpolErm(Function func, double a) {
        this.func = func;
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
        double[] resa = new double[3];
        for (int i = 0; i < points.length; i++) {
            resa[i] = func.f(points[i]);
        }
        double[] resd = new double[3];
        for (int i = 0; i < points.length; i++) {
            resd[i] = func.df(points[i]);
        }
        System.out.println(Arrays.toString(points));
        System.out.println(Arrays.toString(resa));
        System.out.println(Arrays.toString(resd));
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

    Polynom P_N_0;
    Polynom P_N_2;

    public Polynom com() {
        InterpolLagr interpolLagr = new InterpolLagr(func, n, a);
        interpolLagr.setPoints(points);
        P_N_0 = interpolLagr.com();

        /*System.out.println("P_N_0 " + P_N_0);
        System.out.println("omega " + omega(n + 1));
        System.out.println(Arrays.toString(points));
        System.out.println(Arrays.toString(comNewPoints()));*/

        Function3Point ex2 = new Function3Point().setX(points).setY(comNewPoints());
        InterpolLagr interpolLagr2 = new InterpolLagr(ex2, n, a);
        interpolLagr2.setPoints(points);
        P_N_2 = interpolLagr2.com();

        /*System.out.println("P_N_2 " + P_N_2);
        System.out.println("omegan " + omega(n));*/

        return P_N_0.add(omega(n + 1).multiply(P_N_2.add(omega(n))));
        //InterpolLagr interpolLagr = new InterpolLagr(func, n, a);
        //        interpolLagr.setPoints(points);
        //        P_N_0 = interpolLagr.com();
        //        System.out.println("P_N_0 " + P_N_0);
        //        System.out.println("omega " +omega(n + 1));
        //
        //        Function3Point ex2 = new Function3Point().setX(points).setY(comNewPoints());
        //        InterpolLagr interpolLagr2 = new InterpolLagr(ex2, n - 1, a);
        //        interpolLagr2.setPoints(points);
        //        P_N_2 = interpolLagr2.com();
        //        System.out.println("P_N_2 " + P_N_2);
        //        System.out.println("omegan " +omega(n));
        //
        //        return P_N_0.add(omega(n+1).multiply(P_N_2.add(omega(n))));
    }

    private double[] comNewPoints() {
        double[] res = new double[3];
        for (int i = 0; i < res.length; i++) {
            res[i] = P(points[i]);
        }
        return res;
    }

    private double P(double x) {
        return (df(x) - P_N_0.differentiate().valueOf(x)) / omega(n + 1).differentiate().valueOf(x);
    }

    private double df(double x) {
        return func.df(x);
    }

    private double dP(double x) {
        return 0;
    }
}
