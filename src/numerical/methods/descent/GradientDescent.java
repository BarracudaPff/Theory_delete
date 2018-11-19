package numerical.methods.descent;

import numerical.helpers.Matrix;

import static numerical.helpers.Matrix.*;

public class GradientDescent extends QuickestDescent {
    public GradientDescent(Matrix a, Matrix b, Matrix x) {
        super(a, b, x);
    }

    @Override
    public Matrix q() {
        return add(mul(A, X), B);
    }
}
