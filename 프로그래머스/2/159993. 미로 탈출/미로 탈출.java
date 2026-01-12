import java.util.*;

class Solution {
    static int x;
    static int y;
    static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
    static int[] dy = {1, 0, -1, 0};
    public int solution(String[] maps) {
        int answer = 0;
        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;
        x = maps.length;
        y = maps[0].length();
        char[][] map = new char[x][y];
        boolean[][] visit;
        int cnt = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                char ch = maps[i].charAt(j);
                map[i][j] = ch;

                if(ch == 'S'){
                    startX = i;
                    startY = j;
                }
                else if(ch == 'L'){
                    leverX = i;
                    leverY = j;
                }
            }
        }

//        for(int i = 0; i < x; i++){
//            for(int j = 0; j < y; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();

        visit = new boolean[x][y];
        //레버찾기
        cnt = lever(startX, startY, visit, map);
//        System.out.println(cnt);

        //출구를 못찾았을 경우
        if(cnt == -1){
            answer = -1;
        }
        else {
            //레버 찾은 후 출구 찾기!! (방문기록 초기화 해줘야함)
            visit = new boolean[x][y];
            answer = bfs(leverX, leverY, visit, map, cnt);
        }

        return answer;
    }
    static int bfs(int leverX, int leverY, boolean[][] visit, char[][] map, int initCnt){
        //레버 위치에서 시작하는 초기값 설정
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {leverX, leverY, initCnt});
        visit[leverX][leverY] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                int ncnt = cnt + 1;

                //범위 측정
                if(nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
                //이미 방문했는지 체크
                if(visit[nx][ny]) continue;
                //벽 발견
                if(map[nx][ny] == 'X') continue;
                //출구 발견
                if(map[nx][ny] == 'E')
                    return ncnt;

                q.add(new int[] {nx, ny, ncnt});
                visit[nx][ny] = true;
            }
        }

        return -1;
    }
    static int lever(int startX, int startY, boolean[][] visit, char[][] map){
        //초기값 설정
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY, 0});
        visit[startX][startY] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                int ncnt = cnt + 1;

                //범위 측정
                if(nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
                //이미 방문한 곳인지 체크
                if(visit[nx][ny]) continue;
                //벽 발견
                if(map[nx][ny] == 'X') continue;
                //레버 발견
                if(map[nx][ny] == 'L')
                    return ncnt;

                q.add(new int[] {nx, ny, ncnt});
                visit[nx][ny] = true;
            }
        }

        return -1;
    }
}