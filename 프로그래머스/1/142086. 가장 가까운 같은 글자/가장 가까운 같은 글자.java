import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                answer[i] = -1;
            }
            int cnt = 1;
            boolean flag = true;
            for(int j = i; j > 0; j--){
                if(s.charAt(i) == s.charAt(j-1)){
                    answer[i] = cnt;
                    flag = false;
                    break;
                }
                cnt++;
            }
            if(flag) {
                answer[i] = -1;
            }
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }
}