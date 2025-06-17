import java.io.*;
import java.util.*;

class Solution {
    static class bridge{
        int w;
        int time;

        public bridge(int w, int time){
            this.w = w;
            this.time = time;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<bridge> q = new LinkedList<>();

        int time = 0;
        int idx = 0;
        int total = 0;

        while(idx < truck_weights.length || !q.isEmpty()){
            time++;

            // 트럭이 다리를 빠져나가는 시점
            if(!q.isEmpty() && q.peek().time == time){
                total -= q.poll().w;
            }

            //다리 위에 트럭 올려도 될때
            if(idx < truck_weights.length && total + truck_weights[idx] <= weight){
                q.add(new bridge(truck_weights[idx], time + bridge_length));
                total += truck_weights[idx];
                idx++;
            }
        }

        System.out.println(time);

        return time;
    }
}