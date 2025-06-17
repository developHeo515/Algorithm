import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        int idx = 0;
        int cnt = 0;

        while(idx < progresses.length){
            for(int i = idx; i < progresses.length; i++){
                if(progresses[i] >= 100)
                    continue;
                progresses[i] += speeds[i];
            }

            cnt = 0;
            for(int i = idx; i < progresses.length; i++){
                if(progresses[i] >= 100){
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt != 0) {
                list.add(cnt);
            }
            idx += cnt;
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}