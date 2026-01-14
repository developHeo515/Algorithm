import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            //비교할게 없으므로 그냥 넣는다.
            if(stack.isEmpty()) stack.push(s.charAt(i));
            //비교할 대상이 있을때
            else {
                if(stack.peek() == s.charAt(i)) stack.pop();
                else stack.push(s.charAt(i));
            }
        }

        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}