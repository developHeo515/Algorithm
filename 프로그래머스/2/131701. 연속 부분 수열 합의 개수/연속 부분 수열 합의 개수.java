import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> hs = new HashSet<>();
        int[] arr = new int[elements.length * 2];
        for(int i = 0; i < elements.length * 2; i++){
            arr[i] = elements[i % elements.length];
        }

        for(int i = 0; i < elements.length; i++){
            for(int j = i; j < i + elements.length; j++){
                int sum = 0;
                for(int k = j; k < i + elements.length; k++){
                    sum += arr[k];
                }
                hs.add(sum);
            }
        }

        System.out.println(hs.size());

        return answer = hs.size();
    }
}