package numerical.methods.task2;

import lib.com.polynom.polynom.Polynom;

public class Hermite {

    public static void main(String[] args) {
        int N = 6;
        Polynom[] H = new Polynom[Math.max(2, N)];
        H[0] = new Polynom(1, 0);   //  1
        H[1] = new Polynom(2, 1);   //  2x

        // compute Hermite Polynoms
        for (int n = 2; n < N; n++) {
            Polynom temp1 = H[1].multiply(H[n-1]);
            Polynom temp2 = new Polynom(2 * (n-1), 0);   // 2(n-1)
            Polynom temp3 = temp2.multiply(H[n-2]);
            H[n] = temp1.subtract(temp3);
        }

        // print results
        for (int n = 0; n < N; n++)
            System.out.println(H[n]);
    }
}
