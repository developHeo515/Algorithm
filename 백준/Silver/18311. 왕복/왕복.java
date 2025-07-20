import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            K -= arr[i];
            if(K < 0){
                bw.write(i + "\n");
                break;
            }
        }

        if(K > 0){
            for(int i = N; i > 0; i--){
                K -= arr[i];
                if(K < 0){
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
