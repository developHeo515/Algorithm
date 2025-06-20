import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int weight = 0;
        int apple = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("B")){
                weight += 6000;
            }
            else{
                weight += 1000;
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(a >= 12 && b >= 12 && c >= 12){
                    apple += (a/12) * (b/12) * (c/12);
                }
            }
        }

        weight += apple*500;
        apple *= 4000;
        bw.write(weight +"\n");
        bw.write(apple + "\n");
        bw.flush();
    }
}
