import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<>();
        List<Integer> del = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            ans.add(arr[i]);
        }
        for(int i = 0; i < delete_list.length; i++){
            del.add(delete_list[i]);
        }

        for(int d : del){
            if(ans.contains(d)){
                ans.remove(Integer.valueOf(d));
            }
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}