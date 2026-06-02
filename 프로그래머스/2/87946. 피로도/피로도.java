class Solution {
    static int res;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        res = 0;
        boolean[] visit = new boolean[dungeons.length];
        purm(k, dungeons, 0, visit);
        answer = res;

        return answer;
    }

    static void purm(int k, int[][] dungeons, int cnt, boolean[] visit){
        if(cnt > res){
            res = cnt;
            if(res == dungeons.length) return;
        }

        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && k >= dungeons[i][0]){
                visit[i] = true;
                purm(k - dungeons[i][1], dungeons, cnt + 1, visit);
                visit[i] = false;
            }
        }
    }
}