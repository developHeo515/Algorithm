import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int n : tangerine){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            list.add(entry.getValue());
        }

        Collections.sort(list, Collections.reverseOrder());
        int total = 0;
        for(int n : list){
            total += n;
            //귤 다른 종류 더 넣을 수 있을때
            if(total < k){
                answer++;
            }
            //귤 한 상자 다 채웠을 때
            else{
                answer++;
                break;
            }
        }


        return answer;
    }
}