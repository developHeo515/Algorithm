class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};

        answer = new String[strArr.length];

        int idx = 0;
        for(String str : strArr){
            if(idx % 2 == 0) { //짝수 인덱스일 경우 소문자
                answer[idx] = strArr[idx].toLowerCase();
            } else { //홀수 인덱스일 경우 대문자
                answer[idx] = strArr[idx].toUpperCase();
            }
            idx++;
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}