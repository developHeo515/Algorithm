import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Deque<Integer> deque = new ArrayDeque<>();


        int i = 0;

        while(i < arr.length){
            if(deque.isEmpty()){
                deque.add(arr[i]);
                i++;
            }else {
                if(arr[i] > deque.peekLast()){
                    deque.addLast(arr[i]);
                    i++;
                }else {
                    deque.removeLast();
                }
            }
        }

        stk = new int[deque.size()];
        int idx = 0;
        for(int num : deque){
            stk[idx++] = num;
        }
//        System.out.println(Arrays.toString(stk));

        return stk;
    }
}