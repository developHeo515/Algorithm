import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double avg = 0.0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(Integer.parseInt(str) == 100){
                avg += 100;
            } else{
                str = str.replace("0", "9");
                str = str.replace("6", "9");
                avg += Integer.parseInt(str);
            }
        }
        avg = avg / (double) N;
        System.out.println((int) Math.round(avg));     
    }
}