import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] zisu = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                zisu[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int zinseo = zisu[a][b];
        for(int i = 1; i <= N; i++){
            if(zisu[i][b] > zisu[a][b]) zinseo = zisu[i][b];
        }
        for(int i = 1; i <= N; i++){
            if(zisu[a][i] > zisu[a][b]) zinseo = zisu[a][i];
        }
        if(zinseo == zisu[a][b]) bw.write("HAPPY\n");
        else bw.write("ANGRY\n");

        bw.flush();
        br.close();
        bw.close();
    }
}