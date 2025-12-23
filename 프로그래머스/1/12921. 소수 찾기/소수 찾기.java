class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 2; i <= n; i++){
            //소수찾기
            boolean prime = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }

            if(prime) {
//                System.out.println("소수다 : " + i);
                answer++;
            }
        }

        return answer;
    }
}