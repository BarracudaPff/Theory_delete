package numerical.methods.task2.helpers;

import static java.lang.Math.abs;

public interface Function {
    double f(double x);
    double df(double x);
    default double h(double x){
        return abs(x)*f(x);
    }
}
