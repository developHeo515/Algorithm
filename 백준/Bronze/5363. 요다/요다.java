import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String [] str = br.readLine().split(" ");

            for (int j = 2; j < str.length; j++) {
                sb.append(str[j]).append(" ");
            }

            sb.append(str[0]).append(" ").append(str[1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}