package numerical.methods.task2.helpers;

public class Function3Point implements Function {
    double[] x;
    double[] y;

    public Function3Point setX(double[] x) {
        this.x = x;
        return this;
    }

    public Function3Point setY(double[] y) {
        this.y = y;
        return this;
    }

    @Override
    public double f(double v) {
        if (v == x[0])
            return y[0];
        else if (v == x[1])
            return y[1];
        else if (v == x[2])
            return y[2];
        System.err.println("ERROR");
        return 0;
    }

    @Override
    public double df(double x) {
        return 0;
    }
}
