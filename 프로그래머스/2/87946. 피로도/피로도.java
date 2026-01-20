class Solution {
    static int max;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        max = 0;
        permutation(k, dungeons, 0, new boolean[dungeons.length]);

        return answer = max;
    }
    static boolean permutation(int k, int[][] dungeons, int dunCnt, boolean[] visit){
        if(dunCnt > max){
            max = dunCnt;
            if(dunCnt == dungeons.length) return true;
        }

        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i]){
                visit[i] = true;
                //내 피로도 >= 최소 필요 피로도
                if(k >= dungeons[i][0]){
                    //던전 소모 피로도 빼줘야함
                    if(permutation(k - dungeons[i][1], dungeons, dunCnt + 1, visit))
                        return true;
                }
                visit[i] = false;
            }
        }

        return false;
    }
}