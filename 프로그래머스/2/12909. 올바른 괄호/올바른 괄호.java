import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')') {
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}