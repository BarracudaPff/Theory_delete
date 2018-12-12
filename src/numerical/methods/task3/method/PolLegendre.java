package numerical.methods.task3.method;

import lib.com.polynom.polynom.Polynom;
import numerical.methods.task2.helpers.Function;

import static java.lang.Math.pow;

public class PolLegendre {
    private static double N = 1000;
    private final double a;
    private final double b;
    private final Function f;

    public PolLegendre(Function f, double a, double b) {
        this.f = f;
        this.a = a;
        this.b = b;
    }

    public Polynom getPol(int n) {
        Polynom polynom = new Polynom("0");
        for (int i = 0; i <= n; i++) {
            polynom = polynom.add(l(i).multiply(c(i)));
        }
        return polynom;
    }

    public double c(int n) {
        return integrateTop(n) / integrateBot(n);
    }

    private double integrateBot(int k) {
        double h = (b - a) / N;
        double sum = 0.5 * (fBot(a, k) + fBot(b, k));
        for (int i = 1; i < N; i++) {
            double x = a + h * i;
            sum = sum + fBot(x, k);
        }

        return sum * h;
    }

    private double integrateTop(int k) {
        double h = (b - a) / N;
        double sum = 0.5 * (fTop(a, k) + fTop(b, k));
        for (int i = 1; i < N; i++) {
            double x = a + h * i;
            sum = sum + fTop(x, k);
        }

        return sum * h;
    }

    public Polynom l(int n) {
        if (n == 0)
            return new Polynom();
        Polynom polynom = new Polynom(new double[]{1, 0, -1});

        polynom = polynom.power(n);
        polynom = polynom.differentiate(n);
        polynom = polynom.multiply(1 / (fact(n) * pow(2, n)));
        return polynom;
    }

    double fTop(double x, int k) {
        return f.f(x) * l(k).valueOf(x);
    }

    private double fBot(double x, int k) {
        return l(k).valueOf(x) * l(k).valueOf(x);
    }

    double fact(long n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }
}
