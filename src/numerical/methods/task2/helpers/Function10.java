package numerical.methods.task2.helpers;

import static java.lang.Math.sin;

public class Function10 implements Function{

    @Override
    public double f(double x) {
        return x * x + 4 * sin(x) - 2;
    }
}
