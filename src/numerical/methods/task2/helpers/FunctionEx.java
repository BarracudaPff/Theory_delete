package numerical.methods.task2.helpers;

public class FunctionEx implements Function {
    @Override
    public double f(double x) {
        return x + 1;
    }

    @Override
    public double df(double x) {
        if (x == -1)
            return 5;
        if (x == 0)
            return 0;
        return 1;
    }
}
