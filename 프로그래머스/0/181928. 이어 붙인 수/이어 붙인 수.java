class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        int a = 0;
        int b = 0;

        for(int n : num_list){
            if(n % 2 == 0){ //짝수
                a = a * 10 + n;
            }
            else if(n % 2 == 1){ //홀수
                b = b * 10 + n;
            }
        }
        answer = a + b;
        return answer;
    }
}