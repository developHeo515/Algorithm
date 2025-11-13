import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < score.length; i++){
//            System.out.println(score[i] + " ");
            list.add(score[i]);
            Collections.sort(list);
            if(list.size() <= k){
                answer[i] = list.get(0);
            }
            else if(list.size() > k){
                answer[i] = list.get(list.size() - k);
            }
        }
        
        return answer;
    }
}