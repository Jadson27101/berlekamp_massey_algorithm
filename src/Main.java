import java.sql.Array;
import java.util.Arrays;

public class Main {
    private byte b[], t[], c[];
    private int N, L, m;
    private int arrLength;
    private byte s[] = {1,1,1,0,1,1,0,0,0,0,1,0,1};
    private void registryTester(int length) {
        arrLength = length;
        b = new byte[length];
        c = new byte[length];
        t = new byte[length];
        for (int i = 0; i < length; i++) {
            b[i] = c[i] = t[i] = 0;
        }
        b[0] = c[0] = 1;
        N = L = 0;
        m = -1;
    }

    private void run() {
        int d;
        while (N < s.length) {
            d = 0;
            for (int i = 0; i <= L; i++) {
                d += s[N - i] * c[i];
            }
            d = d % 2;

            if (d != 0) {
                System.arraycopy(c, 0, t, 0, arrLength);
                for (int i = 0; i <= s.length + m - 1 - N; i++) {
                    c[N - m + i] = (byte) (c[N - m + i] ^ b[i]);
                }
                if (L <= (N / 2)) {
                    L = N + 1 - L;
                    m = N;
                    System.arraycopy(t, 0, b, 0, arrLength);
                }
            }
            N++;
        }
    }
    public static void main(String[] args){
        Main m = new Main();
        m.registryTester(13);
        m.run();
        System.out.println(Arrays.toString(m.c));
    }
}
