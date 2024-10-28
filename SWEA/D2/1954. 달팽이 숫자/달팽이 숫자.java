import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());

        for(int tc=0; tc<TC; tc++){
            int size = Integer.parseInt(br.readLine());

            map = new int[size][size];

            int row = 0;
            int col = 0;
            int number = 1;
            map[row][col] = number;
            int direction = 0;
            int idx = 0;
            while(true){
                direction = idx % 4;

                while(true){
                     row += dr[direction];
                     col += dc[direction];

                     if(row<0 || col<0 || row>=size || col>=size || map[row][col]!=0){
                         row -= dr[direction];
                         col -= dc[direction];
                         break;
                     }

                     if(map[row][col]==0){
                         map[row][col] = ++number;
                     }
                }

                idx++;

                if(idx==size*2-1)break;
            }

            System.out.println("#"+(tc+1));
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
