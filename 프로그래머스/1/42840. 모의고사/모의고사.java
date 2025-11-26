import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();

        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;
        int[] cnt = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == A[i % A.length]){
                cnt[0]++;
            }
            if(answers[i] == B[i % B.length]){
                cnt[1]++;
            }
            if(answers[i] == C[i % C.length]){
                 cnt[2]++;
            }
        }
        max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);

        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == max){
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}