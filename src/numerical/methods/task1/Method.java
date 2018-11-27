package numerical.methods.task1;

import numerical.methods.task1.helpers.Matrix;

public interface Method {
    double EPSILON = 10e-8;

    Matrix solve();
}
