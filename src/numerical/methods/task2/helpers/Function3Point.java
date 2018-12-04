package numerical.methods.task2.helpers;

public class Function3Point implements Function {
    public double[] x;
    public double[] y;
    public double[] dy;

    public Function3Point setX(double[] x) {
        this.x = x.clone();
        return this;
    }

    public Function3Point setY(double[] y) {
        this.y = y.clone();
        return this;
    }

    public Function3Point setDy(double[] dy) {
        this.dy = dy;
        return this;
    }

    @Override
    public double f(double v) {
        for (int i = 0; i < x.length; i++) {
            if (v == x[i])
                return y[i];
        }
        System.err.println("ERROR f(x)");
        return 0;
    }

    @Override
    public double df(double v) {
        for (int i = 0; i < x.length; i++) {
            if (v == x[i])
                return dy[i];
        }
        System.err.println("ERROR df(x)");
        return 0;
    }
}
