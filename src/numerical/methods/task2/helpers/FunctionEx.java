package numerical.methods.task2.helpers;

public class FunctionEx implements Function {
    @Override
    public double f(double x) {
        return Math.pow(x, 8) + 1;
    }

    @Override
    public double df(double x) {
        /*if (x == -1)
            return 5;
        if (x == 0)
            return 0;
        return 1;*/
        return 8 * Math.pow(x, 7) + 1;
    }
}
