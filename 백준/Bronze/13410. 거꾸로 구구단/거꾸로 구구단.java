import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;

            for (int i = 1; i <= numB; i++) {
                int count = numA * i;
                StringBuilder tmp = new StringBuilder(String.valueOf(count));
                int reverse = Integer.parseInt(tmp.reverse().toString());

                answer = Math.max(answer, reverse);
            }


        sb.append(answer);
        System.out.println(sb.toString());
    }

}