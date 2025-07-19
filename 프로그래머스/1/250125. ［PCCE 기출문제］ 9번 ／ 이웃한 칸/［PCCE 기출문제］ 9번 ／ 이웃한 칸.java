class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0, 1, 0, -1}; //우 하 좌 상
        int[] dy = {1, 0, -1, 0};
        int leng = board.length;

        for(int i = 0; i < 4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
//            System.out.println(nx + " " + ny);
            if(nx < 0 || nx >= leng || ny < 0 || ny >= leng) continue;
            if(board[h][w].equals(board[nx][ny])){
                answer++;
//                System.out.println("answer : " + answer);
            }
        }

        return answer;
    }
}