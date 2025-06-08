import java.io.*;
import java.util.*;

class Solution {
    public class feature {
        int priority;
        int loc;

        public feature(int priority, int loc) {
            this.priority = priority;
            this.loc = loc;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<feature> q = new LinkedList<>();
        List<Integer> pList = new ArrayList<>();

        for(int p : priorities) {
            pList.add(p);
        }

        pList.sort(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++) {
            if(i != location) {
                q.add(new feature(priorities[i], -1));
            }
            else {
                q.add(new feature(priorities[i], location));
            }
        }

        while(!q.isEmpty()) {
            feature cur = q.poll();

            if(cur.priority == pList.get(0)) {
                answer++;

                if(cur.loc == location)
                    break;
                pList.remove(0);
            }
            else {
                q.add(cur);
            }
        }

        return answer;
    }
}