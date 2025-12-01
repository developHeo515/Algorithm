import java.io.*;
import java.util.*;

public class Main {
    static boolean finish = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        boolean[] tf = new boolean[9];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, arr, tf);

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int cnt, int[] arr, boolean[] tf){
        if(finish) return;
        if(cnt == 7){
            //100되는지 탐색
            int sum = 0;
            for(int k = 0; k < 9; k++){
                if(tf[k]){
                    sum += arr[k];
                }
            }
            if(sum == 100){
                int[] result = new int[7];
                int idx = 0;
                for(int k = 0; k < 9; k++){
                    if(tf[k]){
                        result[idx++] = arr[k];
                    }
                }
                Arrays.sort(result);

                for(int r = 0; r < 7; r++){
                    System.out.println(result[r]);
                }
                finish = true;
                return;
            }
            return;
        }

        for(int i = 0; i < 9; i++){
            if(!tf[i]){ //중복안되는 난쟁이일때
                tf[i] = true;
                dfs(cnt+1, arr, tf);
                tf[i] = false;
            }
        }
    }
}