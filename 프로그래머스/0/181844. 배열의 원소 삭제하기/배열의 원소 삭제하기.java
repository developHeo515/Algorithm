import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            ans.add(arr[i]);
        }
        for(int d : delete_list){
            ans.remove((Integer)d);
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}