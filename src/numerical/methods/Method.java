package numerical.methods;

import numerical.helpers.Matrix;

public interface Method {
    double EPSILON = 10e-8;

    Matrix solve();
}
