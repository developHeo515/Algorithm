import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int pmt = Integer.parseInt(br.readLine());
        int pmtb = Integer.parseInt(br.readLine());
        int gj = Integer.parseInt(br.readLine());

        int answer = gj * (pmtb/pmt);

        sb.append(answer);
        System.out.println(sb.toString());
    }
}