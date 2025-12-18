import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 1; i < food.length; i++){
            int n = food[i] / 2;
            for(int j = 0; j < n; j++){
                stack.push(i);
                answer += i;
            }
        }

        answer += 0;

        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        return answer;
    }
}