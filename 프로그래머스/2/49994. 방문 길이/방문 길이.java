class Solution {
    static int cnt = 0;
    // 초기위치 설정
    static int cx = 5;
    static int cy = 5;
    static int nx = 0;
    static int ny = 0;
    public int solution(String dirs) {
        int answer = 0;

        // 각 위치에서 네 방향을 지나갔는지 체크하기 위해 3차원배열 사용
        // 우 하 좌 상 = 0 1 2 3
        boolean[][][] visit = new boolean[11][11][4];

        for(int i = 0; i < dirs.length(); i++){
            char ch = dirs.charAt(i);
            int curDir = 0;
            int nextDir = 0;

            if(ch == 'U'){
                nx = cx - 1;
                ny = cy;
                curDir = 3;
                nextDir = 1;
            }
            else if(ch == 'D'){
                nx = cx + 1;
                ny = cy;
                curDir = 1;
                nextDir = 3;
            }
            else if(ch == 'R'){
                nx = cx;
                ny = cy + 1;
                curDir = 0;
                nextDir = 2;
            }
            else if(ch == 'L'){
                nx = cx;
                ny = cy - 1;
                curDir = 2;
                nextDir = 0;
            }

            // 맵 크기 벗어나는지 확인
            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
            func(visit, curDir, nextDir);
        }

        return answer = cnt;
    }
    static void func(boolean[][][] visit, int cur, int next){
        // 현재 위치에서 위로 갈때와 다음 위치에서 아래로 갈때 길 방문 여부 확인
        if(!visit[cx][cy][cur] && !visit[nx][ny][next]){
            visit[cx][cy][cur] = true;
            visit[nx][ny][next] = true;
            cx = nx;
            cy = ny;
            cnt++; // 최초의 길이라 거리추가
        }
        else {
            cx = nx;
            cy = ny;
        }
    }
}