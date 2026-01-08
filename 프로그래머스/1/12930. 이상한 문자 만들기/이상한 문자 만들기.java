class Solution {
    public String solution(String s) {
        String answer = "";

        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == ' '){
                answer += ch;
                idx = 0;
            }
            else {
                if(idx % 2 == 0){
                    answer += Character.toUpperCase(ch);
                }
                else {
                    answer += Character.toLowerCase(ch);
                }

                idx++;
            }
        }

        return answer;
    }
}