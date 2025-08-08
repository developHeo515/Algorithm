import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = (int)str.charAt(j)-48;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = M-1; j >= 0; j--){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }


        bw.flush();
        bw.close();
        br.close();
    }
}