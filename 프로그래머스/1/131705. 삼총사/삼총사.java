class Solution {
    public int solution(int[] number) {
        int answer = 0;

        int leng = number.length;
        for(int i = 0; i < leng; i++){
            for(int j = i+1; j < leng; j++){
                for(int k = j+1; k < leng; k++){
                    if(number[i] + number[j] + number[k] == 0){
//                        System.out.println(number[i] + " " + number[j] + " " + number[k]);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}