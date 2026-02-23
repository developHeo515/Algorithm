import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        //해시맵 사용
        //두번째 단어부터 이전 단어 끝에꺼 확인
        //n 기준으로 몇번째 순서인지 for문 나누기로 그 순간을 기록(answer[1])
        int[] answer = {};
        HashSet<String> hs = new HashSet<>();

        int seq = 0;
        boolean pass = true;
        char last = words[0].charAt(words[0].length() - 1);
        for(int i = 0; i < words.length; i++){
            char first = words[i].charAt(0);
            if(i % n == 0) seq++;
//            System.out.println((i % n) + " === " + seq + " === " +  words[i]);
            if(i != 0 && last != first || hs.contains(words[i])){
                answer = new int[] {(i % n + 1), seq};
                pass = false;
                break;
            }
            else {
                hs.add(words[i]);
                last = words[i].charAt(words[i].length() - 1);
            }
        }

        if(pass) answer = new int[]{0, 0};
        return answer;
    }
}