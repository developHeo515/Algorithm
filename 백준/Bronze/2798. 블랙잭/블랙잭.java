import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        int[] arr = new int[N];
        boolean[] visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.print(Arrays.toString(arr));

        dfs(0, arr, visit);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt, int[] arr, boolean[] visit){
        if(cnt == 3){
//            System.out.println(Arrays.toString(visit));
            int num = 0;
            for(int i = 0; i < N; i++){
                if(visit[i]){
                    if(M < num + arr[i]){
                        return;
                    }
                    num += arr[i];
                }
            }
            if(max <= num){
                max = num;
//                System.out.println("내가 최근줄 " + " " + Arrays.toString(visit));
            }
            return;
        }

//        System.out.println(cnt);

        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(cnt+1, arr, visit);
                visit[i] = false;
            }
        }


    }
}