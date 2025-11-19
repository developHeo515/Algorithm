class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;

        for(int idx = 0; idx < code.length(); idx++){
            char ch = code.charAt(idx);

            if(ch == '1'){
                if(mode == 0) mode = 1;
                else if(mode == 1) mode = 0;
            }
            else{
                if(mode == 0){
                    if(idx % 2 == 0) answer += ch;
                }
                else if(mode == 1){
                    if(idx % 2 == 1) answer += ch;
                }
            }
        }

        if(answer.equals("")) answer = "EMPTY";
        return answer;
    }
}