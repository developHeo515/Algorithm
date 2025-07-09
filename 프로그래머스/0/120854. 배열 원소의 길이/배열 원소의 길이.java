import java.util.*;
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for(String str : strlist){
            list.add(str.length());
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}