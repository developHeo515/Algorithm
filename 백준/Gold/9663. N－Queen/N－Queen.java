import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] v1 = new int[N];
        int[] v2 = new int[N*2];
        int[] v3 = new int[N*2];

        dfs(0, v1, v2, v3);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt, int[] v1, int[] v2, int[] v3){
        if(cnt == N) {
            answer++;
            return;
        }

        for(int j = 0; j < N; j++){
            if(v1[j] == 0 && v2[cnt+j] == 0 && v3[cnt-j + N] == 0){
                v1[j] = v2[cnt+j] = v3[cnt-j + N] = 1;
                dfs(cnt+1, v1, v2, v3);
                v1[j] = v2[cnt+j] = v3[cnt-j + N] = 0;
            }
        }
    }
}