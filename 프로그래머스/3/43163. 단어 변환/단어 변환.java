class Solution {
    static int res = 987654321;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visit = new boolean[words.length];

        dfs(0, begin, target, words, visit);
        answer = res;
        if(answer == 987654321){
            answer = 0;
        }
        return answer;
    }

    static void dfs(int cnt, String begin, String target, String[] words, boolean[] visit){
//        System.out.println("dfs 시작 : " + begin);
         if(begin.equals(target)){
             if(res > cnt){
                 res = cnt;
//                 System.out.println("최소로 찾음 : " + res);
             }

            return;
        }

        for(int i = 0; i < words.length; i++){
            if(!visit[i]){
                //변환가능한지 검사
                int diff = 0;
                for(int k = 0; k < words[i].length(); k++){
                    if(begin.charAt(k) != words[i].charAt(k)){
                        diff++;
                    }
                }
                if(diff == 1){
                    visit[i] = true;
                    dfs(cnt+1, words[i], target, words, visit);
                    visit[i] = false;
                }
            }
        }
        return;
    }
}