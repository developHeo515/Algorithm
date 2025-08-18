import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                answer[i] = -1;
                hm.put(s.charAt(i), i);
            }
            else{
                answer[i] = i - hm.get(s.charAt(i));
                hm.put(s.charAt(i), i);
            }
        }
        
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}