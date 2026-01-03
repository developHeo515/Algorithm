import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int length = num_list.length;

        for(int i = 0; i < length; i++){
            list.add(num_list[i]);
        }

        if(num_list[length - 2] < num_list[length - 1]){
            int num = num_list[length-1] - num_list[length-2];
            list.add(num);
        }
        else {
            list.add(num_list[length-1] * 2);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}