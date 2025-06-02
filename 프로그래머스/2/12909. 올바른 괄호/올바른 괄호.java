import java.util.*;

class Solution {
    static boolean solution(String s) {
        boolean answer = true;
        
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(stack.size() == 0) {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')') {
				if(stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(s.charAt(i));
				}
			}
		}
		
		if(stack.size() == 0) {
			answer = true;
		}else {
			answer = false;
		}

        return answer;
    }
}