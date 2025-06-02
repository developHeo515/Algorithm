import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        // int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr){
            if(stack.size() == 0 || stack.peek() != num){
                stack.add(num);
            }
        }
        

        return stack;
    }
}