import java.util.*;
class Solution {
    static int cnt;
    static boolean flag;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        cnt = 0;
        flag = false;
        bfs(begin, target, words, new HashSet<>());

        // 단어 변형에 실패했을때
        if(!flag) cnt = 0;

        return answer = cnt;
    }
    static void bfs(String begin, String target, String[] words, HashSet<String> hs){
        Queue<String> q = new ArrayDeque<>();
        hs.add(begin);
        q.offer(begin);

        while(!q.isEmpty()) {
            int qsize = q.size();
            while(qsize-- != 0){
                String cur = q.poll();

                // 같은 단어 발견했을 때
                if(cur.equals(target)) {
                    flag = true;
                    break;
                }

                for(String next : words){
                    if(hs.contains(next)) continue;
                    if(check(cur, next)){
                        hs.add(next);
                        q.offer(next);
                    }
                }
            }
            if(flag) break;
            cnt++;
        }
    }

    static boolean check(String cur, String next){
        int number = 0;
        for(int i = 0; i < cur.length(); i++){
            char a = cur.charAt(i);
            char b = next.charAt(i);
            if(a != b) number++;
        }

        if(number == 1) return true;
        else return false;
    }
}