import java.io.*;
import java.util.*;

public class Main {
    static class Fish {
        int r, c, idx, dir;
        boolean isAlive = true;
        Fish(int r, int c, int idx, int dir, boolean isAlive) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[] arr = new Fish[17];
        int[][] map = new int[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                arr[num] = new Fish(i, j, num, direction-1, true);
                map[i][j] = num;
            }
        }

        dfs(0, 0, 0, 0, arr, map);
        System.out.println(ans);
    }

    public static void dfs(int r, int c, int dir, int sum, Fish[] fishes, int[][] map){
        sum += map[r][c];
        dir = fishes[map[r][c]].dir;
        fishes[map[r][c]].isAlive = false;

        ans = Math.max(ans, sum);

        //물고기 이동
        for(int f=1; f<=16; f++){
            if(fishes[f].isAlive){
                move_fish(r, c, fishes[f], fishes, map);
            }
        }

        //상어 이동
        for(int i=1; i<=3; i++){
            int nr = r + dx[dir]*i;
            int nc = c + dy[dir]*i;

            //범위를 초과했거나 물고기가 없는 칸
            if(nr<0 || nc<0 || nr>=4 || nc>=4 || !fishes[map[nr][nc]].isAlive) continue;

            //fishes, map 복제
            Fish[] tempFish = new Fish[17];
            for(int f=1; f<=16; f++){
                Fish fish = fishes[f];
                tempFish[f] = new Fish(fish.r, fish.c, fish.idx, fish.dir, fish.isAlive);
            }

            int[][] tempMap = new int[4][4];
            for(int t=0; t<4; t++){
                tempMap[t] = map[t].clone();
            }

            dfs(nr, nc, dir, sum, fishes, map);

            fishes = tempFish;
            map = tempMap;

        }
    }

    public static void move_fish(int r, int c, Fish fish, Fish[] fishes, int[][] map){
        for(int i=0; i<8; i++){
            int nr = fish.r + dx[fish.dir];
            int nc = fish.c + dy[fish.dir];

            //범위를 초과했거나 상어가 있는 칸
            if(nr<0 || nc<0 || nr>=4 || nc>=4 || (nr==r && nc==c)) {
                fish.dir = (fish.dir+1)%8;
                continue;
            }

            //위치를 바꿈
            Fish target = fishes[map[nr][nc]];
            map[fish.r][fish.c] = target.idx;
            map[nr][nc] = fish.idx;       
            target.r = fish.r; target.c = fish.c; 
            fish.r = nr; fish.c = nc; 
            break;
        }
    }
}