import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        StringTokenizer st;
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for(String str : operations){
            st = new StringTokenizer(str);
            String Operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(Operation.equals("I")){
                pqMin.offer(num);
                pqMax.offer(num);
            }
            else if(Operation.equals("D")){
                //제거할 값이 없다면 패스
                if(pqMin.isEmpty() || pqMax.isEmpty()) continue;

                int rm = 0;
                //최댓값 삭제
                if(num == 1){
                    rm = pqMax.poll();
                    pqMin.remove(rm);
                }
                //최솟값 삭제
                else if(num == -1){ //
                    rm = pqMin.poll();
                    pqMax.remove(rm);
                }
            }
        }

        if(pqMin.isEmpty()) answer = new int[] {0, 0};
        else answer = new int[] {pqMax.peek(), pqMin.peek()};

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}