import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for(int j = 0; j < num; j++){
                int time = Integer.parseInt(st.nextToken());
                cnt += time;
            }
            arr[i] = cnt;
        }

        Arrays.sort(arr);
        for(int i = 0; i < N; i++){
            if(i == 0){
                continue;
            }
            else {
                arr[i] = arr[i] + arr[i-1];
            }
        }

        long res = 0;
        for(int i = 0; i < N; i++){
           res += arr[i];
        }
        bw.write(res + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}