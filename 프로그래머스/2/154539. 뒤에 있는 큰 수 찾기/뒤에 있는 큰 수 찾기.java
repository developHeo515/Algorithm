import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(numbers[numbers.length - 1]);
        answer[numbers.length - 1] = -1;

        for(int i = numbers.length - 2; i >= 0; i--){
            boolean flag = false;
//            System.out.println(numbers[i] + " ==== " + stack);
            while(!stack.isEmpty()){
                if(numbers[i] < stack.peek()){
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                    flag = true;
                    break;
                }
                else {
                    stack.pop();
                }
            }

            if(answer[i] == 0) answer[i] = -1;
            if(!flag) stack.push(numbers[i]);
        }
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}