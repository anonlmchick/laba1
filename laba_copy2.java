import java.util.Random;

public class laba_copy2 {
    

    public static double calc(long s, double x) {
        if (s == 14) {
            return 0.25 * (1 / Math.exp(Math.abs(x)));
        } else if (s == 8 || s == 10 || s == 12 || s == 16) {
            double temp = (0.25 - Math.asin((x + 6) / 18)) / Math.PI / 2;
            return Math.pow(temp, 3);
        } else {
            double e = (0.5 - x) / x;
            double sin = Math.sin(Math.exp(e));
            return Math.atan(Math.pow(sin, 2));
        }
    }
    
    public static void main(String[] args) {
        long[] s = new long[8];
        int index = 0;
        for (long i = 18; i >= 4; i -= 2) {
            s[index++] = i;
        }
        double[] x = new double[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            x[i] = -3.0 + random.nextDouble() * 15.0;
        }
        double[][] w = new double[8][20];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {
                w[i][j] = calc(s[i], x[j]);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.printf("%.3f\t", w[i][j]);
            }
            System.out.println();
        }
    }
}