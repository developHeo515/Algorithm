class Solution {
    public int solution(int n) {
        int answer = 0;

        String nBinary = "";
        int num = n;
        int aCnt = 0;

        nBinary = Integer.toBinaryString(num);

//        System.out.println(nBinary);
        for(int i = 0; i < nBinary.length(); i++){
            if(nBinary.charAt(i) == '1') aCnt++;
        }

        //다음 큰 숫자 찾기
        while(true){
            String nextBinary = "";
            int bCnt = 0;
            num++;
//            System.out.println(num);

            nextBinary = Integer.toBinaryString(num);

            for(int i = 0; i < nextBinary.length(); i++){
                if(nextBinary.charAt(i) == '1') bCnt++;
            }

            if(aCnt == bCnt) {
                answer = num;
                break;
            }
        }
        
        return answer;
    }
}