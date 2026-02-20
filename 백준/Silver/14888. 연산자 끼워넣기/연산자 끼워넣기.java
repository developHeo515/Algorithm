import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(operator, A, 0, N, new ArrayList<>());
        bw.write(max + "\n" + min + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
    static void dfs(int[] operator, int[] A, int depth, int N, List<Integer> select){
        if(depth == N - 1){
            int num = A[0];
            int idx = 1;
            for(int oper : select){
                if(oper == 0) num += A[idx++];
                else if(oper == 1) num -= A[idx++];
                else if(oper == 2) num *= A[idx++];
                else if(oper == 3) num /= A[idx++];
            }
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for(int i = 0; i < 4; i++){
            //연산자를 사용 가능할때
            if(operator[i] != 0){
                operator[i]--;
                select.add(i);
                dfs(operator, A, depth+1, N, select);
                operator[i]++;
                select.remove(select.size() - 1);
            }
        }
    }
}