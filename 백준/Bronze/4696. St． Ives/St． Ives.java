import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            double n = Double.parseDouble(br.readLine());
            if(n == 0)
                break;
            System.out.printf("%.2f\n", 1 + n + n*n + n*n*n + n*n*n*n);
        }

        br.close();
    }
}