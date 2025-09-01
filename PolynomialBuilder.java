// PolynomialBuilder.java
import java.math.BigInteger;
import java.util.*;

public class PolynomialBuilder {
    public static BigInteger[] buildPolynomialFromRoots(List<BigInteger> roots) {
        int degree = roots.size();
        BigInteger[] coeffs = new BigInteger[degree + 1];
        Arrays.fill(coeffs, BigInteger.ZERO);
        coeffs[0] = BigInteger.ONE; // start with constant 1

        for (BigInteger root : roots) {
            BigInteger[] newCoeffs = new BigInteger[coeffs.length];
            Arrays.fill(newCoeffs, BigInteger.ZERO);

            for (int i = 0; i < coeffs.length; i++) {
                if (coeffs[i] == null) continue;

                // multiply by x
                if (i + 1 < newCoeffs.length) {
                    newCoeffs[i + 1] = newCoeffs[i + 1].add(coeffs[i]);
                }
                // multiply by (-root)
                newCoeffs[i] = newCoeffs[i].subtract(coeffs[i].multiply(root));
            }
            coeffs = newCoeffs;
        }
        return coeffs;
    }
}
