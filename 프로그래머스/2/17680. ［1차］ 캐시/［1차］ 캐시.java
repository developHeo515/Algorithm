import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Deque<String> dq = new ArrayDeque<>();

        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }

        for(int i = 0; i < cities.length; i++){
            if(cacheSize == 0){
                answer += 5;
                continue;
            }

            // Hit
            if(dq.contains(cities[i])){
                dq.remove(cities[i]);
                dq.addFirst(cities[i]);
                answer += 1;
            }
            // Miss
            else {
                // 캐시 가득 찼을때
                if(dq.size() == cacheSize){
                    dq.pollLast();
                    dq.addFirst(cities[i]);
                    answer += 5;
                }
                else {
                    dq.addFirst(cities[i]);
                    answer += 5;
                }
            }
        }


        return answer;
    }
}