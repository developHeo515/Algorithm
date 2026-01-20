class Solution {
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        permutation(k, dungeons, 0, new boolean[dungeons.length]);
        return max;
    }
    static boolean permutation(int k, int[][] dungeons, int dunCnt, boolean[] visit){
        if(dunCnt > max){
            max = dunCnt;
            if(dunCnt == dungeons.length) return true;
        }

        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && k >= dungeons[i][0]){
                visit[i] = true;
                if(permutation(k - dungeons[i][1], dungeons, dunCnt + 1, visit)) return true;
                visit[i] = false;
            }
        }
        return false;
    }
}