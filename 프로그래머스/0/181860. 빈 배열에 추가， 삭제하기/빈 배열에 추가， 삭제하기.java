import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int cnt;

        for(int i = 0; i < arr.length; i++){
            if(flag[i] == true){
                for(int j = 0; j < 2 * arr[i]; j++){
                    list.add(arr[i]);
                }
            }
            else if(flag[i] == false){
                for(int j = 0; j < arr[i]; j++){
                    list.remove(list.size()-1);
                }
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}