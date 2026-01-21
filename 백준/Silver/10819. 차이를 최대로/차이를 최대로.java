import java.io.*;
import java.util.*;

public class Main {
    static int max;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        dfs(0, new boolean[N], new int[N], A);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, boolean[] visit, int[] select, int[] A){
        if(depth == N){
            //N개의 순서가 정해졌으니 계산시작
            int sum = 0;
            for(int i = 0; i < N-1; i++){
                sum += Math.abs(select[i] - select[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                select[depth] = A[i];
                dfs(depth + 1, visit, select, A);
                visit[i] = false;
            }
        }
    }
}