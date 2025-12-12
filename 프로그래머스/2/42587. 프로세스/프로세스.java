import java.util.*;

class Solution {
    static class feature {
        int loc;
        int priority;
        public feature(int loc, int priority){
            this.loc = loc;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<feature> q = new ArrayDeque<>();
        Integer[] arr = new Integer[priorities.length];

        for(int i = 0; i < priorities.length; i++){
            q.add(new feature(i, priorities[i]));
            arr[i] = priorities[i];
        }

        //int배열을 내림차순하는 방법
        Arrays.sort(arr, Collections.reverseOrder());

        int idx = 0;
        int sequence = 0;
        while(!q.isEmpty()){
            feature cur = q.poll();

            //우선순위가 제일 높을때
            if(cur.priority == arr[idx]){
                //실행(출력)순서
                sequence++;
                idx++;
                if(cur.loc == location){
                    answer = sequence;
                    break;
                }
            }
            else {
                q.add(cur);
            }
        }

        return answer;
    }
}