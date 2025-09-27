import java.util.Random;

class laba {
    public static void main (String[] args) {
        long[] s = new long[8];
        int ind_s = 0;
        for (long i = 18; i >= 4; i-=2) {
            s[ind_s] = i;
            ind_s ++;
        }


        double[] x = new double[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            x[i] = -3.0 + random.nextDouble() * 18.0;
        }
        double[][] w = new double[8][20];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j<20; j++){
                double ex = x[j];

                if (s[i] == 14) {
                    w[i][j] = 0.25 * (1/Math.exp(Math.abs(ex)));
                } else if (s[i] == 8 || s[i] == 10 || s[i] == 12 || s[i] == 16) {
                    double temp = (0.25 - Math.asin((ex + 6) / 18)) / Math.PI / 2;
                    w[i][j] = Math.pow(temp, 3);
                } else {
                    double e = (0.5 - ex) / ex;
                    double sin = Math.sin(Math.exp(e));
                    w[i][j] = Math.atan(Math.pow(sin, 2));
                }
            }
        }
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<20; j++) {
                System.out.printf("%.3f\t", w[i][j]);
            }
            System.out.println();
        }
    }
}
