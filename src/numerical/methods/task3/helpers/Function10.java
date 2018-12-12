package numerical.methods.task3.helpers;

import numerical.methods.task2.helpers.Function;

import static java.lang.Math.sin;

public class Function10 implements Function {
    @Override
    public double f(double x) {
        return x*x+sin(x);
    }

    @Override
    public double df(double x) {
        return 0;
    }
}
