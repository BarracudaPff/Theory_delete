package numerical.methods.task2.helpers;

public class Function11 implements Function {
    @Override
    public double f(double x) {
        return x * x - Math.cos(10 * x);
    }

    @Override
    public double df(double x) {
        return 2 * (x + 5 * Math.sin(10 * x));
    }
}
