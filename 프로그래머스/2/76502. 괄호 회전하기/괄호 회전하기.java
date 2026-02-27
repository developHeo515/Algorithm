import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> q = new ArrayDeque<>();
        Deque<Character> stack;

//        s를 왼쪽으로 x칸만큼 회전
//        각 큐 복사본 만들어놓고 스택을 활용해 올바른지 확인

        for(int i = 0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }

//        1. s를 왼쪽으로 x칸만큼 회전
        for(int i = 0; i < s.length(); i++){
            //올바른지 검사
            stack = new ArrayDeque<>();
            boolean flag = true;
            for(char ch : q) {
//                System.out.print(ch);

                if(stack.isEmpty()) {
                    // 비어있는 상태에서 여는 괄호만 들어와야 올바른 괄호임
                    if(ch == '[' || ch == '{' || ch == '(') stack.push(ch);
                    // 닫는 괄호 들어오면 그냥 실패라서 넘겨야함
                    else {
                        flag = false;
                        break;
                    }
                }
                else {
                    if(stack.peek() == '['){
                        if(ch == ']') stack.pop();
                        else if(ch == '}' || ch == ')') {
                            flag = false;
                            break;
                        }
                        else stack.push(ch);
                    }
                    else if(stack.peek() == '{'){
                        if(ch == '}') stack.pop();
                        else if(ch == ']' || ch == ')') {
                            flag = false;
                            break;
                        }
                        else stack.push(ch);
                    }
                    else if(stack.peek() == '('){
                        if(ch == ')') stack.pop();
                        else if(ch == ']' || ch == '}') {
                            flag = false;
                            break;
                        }
                        else stack.push(ch);
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag && stack.isEmpty()) answer++;

            //회전하기
            q.offer(q.poll());
//            System.out.println();
        }

        return answer;
    }
}