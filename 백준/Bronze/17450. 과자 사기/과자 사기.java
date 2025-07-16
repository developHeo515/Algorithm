import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        double best = 0;
        String snack = "";

        for(int i = 1; i <= 3; i++){
            st = new StringTokenizer(br.readLine());
            double price = Double.parseDouble(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());

            double calcul = 0;

            if(price * 10 >= 5000){
                calcul = (weight * 10) / (price * 10 - 500);
            }
            else {
                calcul = (weight * 10) / (price * 10);
            }

            if(best < calcul){
                best = calcul;
                if(i == 1) snack = "S";
                else if(i == 2) snack = "N";
                else if(i == 3) snack = "U";
            }
        }

        bw.write(snack + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}
