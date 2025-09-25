import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if (n == 1) {
            System.out.println(-1);
            return;
        }
        long div = 1l * k * n / (n-1);
        long remainder = 1l * k * n % (n-1);
        if (remainder > 0L) div++;
        System.out.println(div);
    }

}