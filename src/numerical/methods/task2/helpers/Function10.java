package numerical.methods.task2.helpers;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Function10 implements Function {

    @Override
    public double f(double x) {
        return x * x + 4 * sin(x) - 2;
    }

    @Override
    public double df(double x) {
        return 2 * (x + 2 * cos(x));
    }

    @Override
    public double dff(double x) {
        return 2 - 4 * sin(x);
    }
}
