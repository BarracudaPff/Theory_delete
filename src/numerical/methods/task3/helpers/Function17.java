package numerical.methods.task3.helpers;

import numerical.methods.task2.helpers.Function;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class Function17 implements Function {
    @Override
    public double f(double x) {
        return exp(x) * pow(x - 2, 2);
    }

    @Override
    public double df(double x) {
        return 0;
    }
}
