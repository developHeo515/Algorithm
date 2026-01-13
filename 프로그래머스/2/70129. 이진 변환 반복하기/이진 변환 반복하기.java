class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int repeat = 0;
        int removeZero = 0;

        while(!s.equals("1")){
            //이진 변환의 횟수 증가
            repeat++;

            // 1. x의 모든 0을 제거합니다.
            String str = "";
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1')
                    str += s.charAt(i);
                else
                    removeZero++;
            }
            s = str;

            // 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
            int length = s.length();
            s = Integer.toString(length, 2);
//            System.out.println("===== " + s);
        }

        answer = new int[] {repeat, removeZero};

        return answer;
    }
}