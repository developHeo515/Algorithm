import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i < speeds.length; i++){
            int remain = (100 - progresses[i]) / speeds[i];
            int quot = (100 - progresses[i]) % speeds[i];
            if(quot != 0){
                remain++;
            }

            //앞에 애들 먼저 배포해야할때
            if(!q.isEmpty() && q.peek() < remain){
                list.add(q.size());
                q.clear();

                //앞에 애들 다 배포하고 새로 저장
                q.add(remain);
            }
            else {
                q.add(remain);
            }
        }

        if(!q.isEmpty()){
            list.add(q.size());
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}