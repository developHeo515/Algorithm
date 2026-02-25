import java.util.*;

class Solution {
    static HashSet<Set<String>> hs = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        //list에 조건에 해당하는 유저를 넣기
        //조건은 *포함해서 같은 문자들일때(check함수 만들기)
        //list 수가 banned_id 배열 수랑 같으면 Hs에 넣기
        purm(user_id, banned_id, 0, new HashSet<>(), new boolean[user_id.length]);
//        System.out.println(hs);
        return answer = hs.size();
    }
    static void purm(String[] user_id, String[] banned_id, int depth, HashSet<String> hsList, boolean[] visit){
        if(depth == banned_id.length){
            //hs에 저장해도 hsList 객체는 계속 변경되기에 새로운 객체로 저장해줘야함
            HashSet<String> temp = new HashSet<>(hsList);
            hs.add(temp);
            return;
        }

        for(int i = 0; i < user_id.length; i++){
            if(!visit[i]){
                if(check(user_id[i], banned_id[depth])){
                    visit[i] = true;
                    hsList.add(user_id[i]);
                    purm(user_id, banned_id, depth + 1, hsList, visit);
                    hsList.remove(user_id[i]);
                    visit[i] = false;
                }
            }
        }
    }

    static boolean check(String user, String banned){
        if(user.length() != banned.length()){
            return false;
        }
        for(int i = 0; i < user.length(); i++){
            char ch = banned.charAt(i);
            if(ch == '*') continue;
            if(user.charAt(i) != ch) return false;
        }
        //모든 문자가 같을때
        return true;
    }
}