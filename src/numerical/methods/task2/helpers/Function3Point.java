package numerical.methods.task2.helpers;

public class Function3Point implements Function {
    public double[] x;
    public double[] y;

    public Function3Point setX(double[] x) {
        this.x = x.clone();
        return this;
    }

    public Function3Point setY(double[] y) {
        this.y = y.clone();
        return this;
    }

    @Override
    public double f(double v) {
        for (int i = 0; i < x.length; i++) {
            if (v==x[i])
                return y[i];
        }
        /*if (v == x[0])
            return y[0];
        else if (v == x[1])
            return y[1];
        else if (v == x[2])
            return y[2];*/
        System.err.println("ERROR");
        return 0;
    }

    @Override
    public double df(double x) {
        return 0;
    }
}
