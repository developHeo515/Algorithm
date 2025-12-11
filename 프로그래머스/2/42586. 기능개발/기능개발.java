import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        int day = 0;
        int idx = 0;
        int cnt = 0;

        while(speeds.length > idx){
            if(progresses[idx] + (day * speeds[idx]) >= 100){
                cnt++;
                idx++;
            }
            else {
                if(cnt != 0){
                    list.add(cnt);
                    cnt = 0;
                }
                day++;
            }
        }

        if(cnt != 0){
            list.add(cnt);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            // System.out.print(answer[i] + " ");
        }

        return answer;
    }
}