import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        List<Integer> list = new ArrayList<>();

        int i = 0;

        while(i < arr.length){
            if(list.size() == 0){
                list.add(arr[i]);
                i++;
            }else {
                if(arr[i] > list.get(list.size() - 1)){
                    list.add(arr[i]);
                    i++;
                }else {
                    list.remove(list.size() - 1);
                }
            }
        }

        stk = new int[list.size()];
        for(int idx = 0; idx < list.size(); idx++){
            stk[idx] = list.get(idx);
        }
//        System.out.println(Arrays.toString(stk));

        return stk;
    }
}