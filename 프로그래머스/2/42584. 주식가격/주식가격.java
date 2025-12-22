import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < prices.length; i++){
            // [디버깅] 가격이 떨어졌을때 prices[i]가 뒤에 시간이다.
//            if(!stack.isEmpty()){
//                System.out.println(prices[stack.peek()] + " == " + stack.peek() + " == " + prices[i]);
//            }
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}