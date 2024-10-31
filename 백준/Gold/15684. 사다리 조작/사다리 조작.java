

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static boolean possible;
    static int[][] save;
    static List<int[]> remains;
    static int[][] ladders;
    static int[][] copy;
    static int N, M, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladders = new int[N+1][H+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladders[b][a] = b+1;
            ladders[b+1][a] = b;
        }

        remains = new ArrayList<>();
        for(int i=1; i<N; i++){
            for(int j=1; j<=H; j++){
                if(ladders[i][j]==0){
                    remains.add(new int[] {i, j});
                }
            }
        }

        copy = new int[N+1][H+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= H; j++){
                copy[i][j] = ladders[i][j];
            }
        }

        int MAX = (N-1)*H-M;
        save = new int[MAX][2];
        possible = false;
        result = Integer.MAX_VALUE;
        for(int i=0; i<=3; i++){
            if(possible)break;
            combination(0, 0, i);
        }

        result = (result>3)?-1:result;

        System.out.println(result);
    }

    static void combination(int depth, int start, int end){
        if(possible)return;

        if(depth == end){
            if(game(end)){
                result = end;
                possible = true;
            }
            return;
        }

        for(int i=start; i<remains.size(); i++){
            save[depth] = remains.get(i);
            combination(depth+1, i+1, end);
        }
    }

    static boolean game(int size){
        restoreLadders();

        for(int i=0; i<size; i++){
            int b = save[i][0];
            int a = save[i][1];
            ladders[b][a] = b+1;
            ladders[b+1][a] = b;
        }

        for(int i=1; i<=N; i++){
            int[] start = ladders[i];
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[H+1];
            queue.add(start);
            int destination = i;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int j=1; j<=H; j++){
                    if(visited[j])continue;

                    int next = cur[j];
                    if(next==0){
                        visited[j] = true;
                        continue;
                    }

                    queue.add(ladders[next]);
                    visited[j] = true;
                    destination = next;
                    break;
                }
            }

            if(destination!=i){
                return false;
            }
        }

        return true;
    }

    static void restoreLadders(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= H; j++){
                ladders[i][j] = copy[i][j];
            }
        }
    }
}