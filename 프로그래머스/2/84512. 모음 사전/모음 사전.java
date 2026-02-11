class Solution {
    static int answer = 0;
    static int cnt = 0;
    public int solution(String word) {
        char[] ch = {'A', 'E', 'I', 'O', 'U'};
        dfs("", word, ch);
        return answer;
    }
    static boolean dfs(String w, String word, char[] ch){
        if(word.equals(w)){
            answer = cnt;
            return true;
        }

        if(w.length() == 5) return false;
        for(int i = 0; i < ch.length; i++){
            cnt++;
            if(dfs(w + ch[i], word, ch)) {
                // 단어 찾았으면 그냥 계속 return
                return true;
            }
        }
        return false;
    }
}