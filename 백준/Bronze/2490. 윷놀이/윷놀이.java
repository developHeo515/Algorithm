import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        int[] arr = new int[4];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = 0;

            for(int j = 0; j < 4; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) cnt++;
            }

            if(cnt == 3){
                bw.write("A" + "\n");
            }
            else if(cnt == 2){
                bw.write("B" + "\n");
            }
            else if(cnt ==1){
                bw.write("C" + "\n");
            }
            else if(cnt == 0){
                bw.write("D" + "\n");
            }
            else if(cnt == 4){
                bw.write("E" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
