// Main.java
import java.math.BigInteger;
import java.util.*;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        // JSON pasted here as a Java string
        String jsonText = "{"
            + "\"keys\": {\"n\": 10, \"k\": 7},"
            + "\"1\": {\"base\": \"6\", \"value\": \"13444211440455345511\"},"
            + "\"2\": {\"base\": \"15\", \"value\": \"aed7015a346d635\"},"
            + "\"3\": {\"base\": \"15\", \"value\": \"6aeeb69631c227c\"},"
            + "\"4\": {\"base\": \"16\", \"value\": \"e1b5e05623d881f\"},"
            + "\"5\": {\"base\": \"8\", \"value\": \"316034514573652620673\"},"
            + "\"6\": {\"base\": \"3\", \"value\": \"2122212201122002221120200210011020220200\"},"
            + "\"7\": {\"base\": \"3\", \"value\": \"20120221122211000100210021102001201112121\"},"
            + "\"8\": {\"base\": \"6\", \"value\": \"20220554335330240002224253\"},"
            + "\"9\": {\"base\": \"12\", \"value\": \"45153788322a1255483\"},"
            + "\"10\": {\"base\": \"7\", \"value\": \"1101613130313526312514143\"}"
            + "}";

        JsonObject obj = JsonParser.parseString(jsonText).getAsJsonObject();

        int n = obj.getAsJsonObject("keys").get("n").getAsInt();
        int k = obj.getAsJsonObject("keys").get("k").getAsInt();
        int degree = k - 1;

        // decode roots using RootDecoder
        List<BigInteger> roots = RootDecoder.decodeRoots(obj);
        System.out.println("Decoded roots: " + roots);

        // take first degree roots
        List<BigInteger> usedRoots = roots.subList(0, degree);

        // build polynomial coefficients using PolynomialBuilder
        BigInteger[] coeffs = PolynomialBuilder.buildPolynomialFromRoots(usedRoots);

        // print polynomial
        System.out.println("Polynomial coefficients:");
        for (int i = coeffs.length - 1; i >= 0; i--) {
            System.out.println("x^" + i + " : " + coeffs[i]);
        }
    }
}
