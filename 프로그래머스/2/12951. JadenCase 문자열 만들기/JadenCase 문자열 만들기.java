class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.toLowerCase().split("");
        boolean flag = true;

        for(String str : arr){
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }

        return answer;
    }
}