import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        for(String[] clothe : clothes){
            hm.put(clothe[1], hm.getOrDefault(clothe[1], 0) + 1);
        }

        answer = 1;
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            answer *= (entry.getValue() + 1);
        }

        answer -= 1;

        return answer;
    }
}