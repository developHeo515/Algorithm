import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};

        answer = new String[my_string.length()];

        for(int i = 0; i < my_string.length(); i++){
            answer[i] = my_string.substring(i, my_string.length());
        }

        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}