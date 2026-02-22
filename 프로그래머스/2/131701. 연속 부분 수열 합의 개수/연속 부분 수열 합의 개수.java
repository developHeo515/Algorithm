import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> hs = new HashSet<>();

        for(int len = 1;len <= elements.length; len++){
            int sum = 0;
            for(int i = 0;i<elements.length;i++){
                sum += elements[(i + len - 1) % elements.length];
                hs.add(sum);
            }
        }

        return hs.size();
    }
}