class Solution {
    public String solution(String s) {
        String answer = "";

        int idx = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(idx == 0){ //대문자로 만들기
                if(ch >= 'a' && ch <= 'z'){
                    answer += Character.toUpperCase(ch);
                    idx++;
                }
                else if(ch == ' '){
                    answer += ch;
                    idx = 0;
                }
                else {
                    answer += ch;
                    idx++;
                }
            }
            else { //소문자로 만들기
                if(ch == ' '){
                    answer += ch;
                    idx = 0;
                }
                else {
                    answer += Character.toLowerCase(ch);
                }
            }
        }

        return answer;
    }
}