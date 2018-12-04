package numerical.methods.task2.helpers;

import static java.lang.Math.log;

public class Function20 implements Function {
    @Override
    public double f(double x) {
        return Math.pow(2, x) * Math.pow((x - 1), 2) - 2;
    }

    @Override
    public double df(double x) {
        return Math.pow(2, x) * (x - 1) * (x * log(2) + 2 - log(2));
    }
}
