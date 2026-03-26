class Solution {
    public int solution(String dirs) {
        int answer = 0;

        // 각 위치에서 네 방향을 지나갔는지 체크하기 위해 3차원배열 사용
        // 우 하 좌 상 = 0 1 2 3
        boolean[][][] visit = new boolean[11][11][4];
        // 초기위치 설정
        int cx = 5;
        int cy = 5;
        int nx = 0;
        int ny = 0;

        for(int i = 0; i < dirs.length(); i++){
            char ch = dirs.charAt(i);

            if(ch == 'U'){
                nx = cx - 1;
                ny = cy;

                // 맵 크기 벗어나는지 확인
                if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
                // 현재 위치에서 위로 갈때와 다음 위치에서 아래로 갈때 길 방문 여부 확인
                if(!visit[cx][cy][3] && !visit[nx][ny][1]){
                    visit[cx][cy][3] = true;
                    visit[nx][ny][1] = true;
                    cx = nx; // x축만 변경된다.
                    answer++; // 최초의 길이라 거리추가
                }
                else {
                    cx = nx;
                }
            }
            else if(ch == 'D'){
                nx = cx + 1;
                ny = cy;

                if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
                if(!visit[cx][cy][1] && !visit[nx][ny][3]){
                    visit[cx][cy][1] = true;
                    visit[nx][ny][3] = true;
                    cx = nx;
                    answer++;
                }
                else {
                    cx = nx;
                }
            }
            else if(ch == 'R'){
                nx = cx;
                ny = cy + 1;

                if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
                if(!visit[cx][cy][0] && !visit[nx][ny][2]){
                    visit[cx][cy][0] = true;
                    visit[nx][ny][2] = true;
                    cy = ny;
                    answer++;
                }
                else {
                    cy = ny;
                }
            }
            else if(ch == 'L'){
                nx = cx;
                ny = cy - 1;

                if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
                if(!visit[cx][cy][2] && !visit[nx][ny][0]){
                    visit[cx][cy][2] = true;
                    visit[nx][ny][0] = true;
                    cy = ny;
                    answer++;
                }
                else {
                    cy = ny;
                }
            }


        }

        return answer;
    }
}