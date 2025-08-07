import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());

        double s = Math.sqrt(2 / (3 * Math.sqrt(3)) * a);

        System.out.println(s * 6);
    }
}