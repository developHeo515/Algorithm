class Solution {
    public int solution(int n) {
        int answer = 0;
        String aStr = "";
        int num = n;
        int aCnt = 0;

        aStr = Integer.toBinaryString(num);
//        System.out.println(sb);
        for(int i = 0; i < aStr.length(); i++){
            if(aStr.charAt(i) == '1') aCnt++;
        }

        //다음 큰 숫자 찾기
        int count = 0;
        while(true){
            count++;
            String bStr = "";
            int bCnt = 0;
            num = n + count;
//            System.out.println(n + " = " + count + " = " + num);
            bStr = Integer.toBinaryString(num);

            for(int i = 0; i < bStr.length(); i++){
                if(bStr.charAt(i) == '1') bCnt++;
            }

            if(aCnt == bCnt) {
                answer = n + count;
                break;
            }
        }

        return answer;
    }
}