class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }

        return answer;
    }
    static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(min != 0){
            int remain = max % min;
            max = min;
            min = remain;
        }

        return max;
    }
}