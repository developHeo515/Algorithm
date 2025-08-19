import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            set.add(num);
        }

        for(int i : set){
            int cnt = 1;
            int prepare = arr[0];
            for(int j = 1; j < N; j++){
               if(arr[j] == i) continue;
               else if(prepare == arr[j]) cnt++;
               else if(prepare != arr[j]){
                   prepare = arr[j];
                   max = Math.max(max, cnt);
                   cnt = 1;
               }
            }
            max = Math.max(max, cnt);
        }


        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
