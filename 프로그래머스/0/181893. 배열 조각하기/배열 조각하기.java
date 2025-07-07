import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};

        for(int i = 0; i < query.length; i++){
            if(i % 2 == 0){ //짝수일 경우
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            }
            else if(i % 2 == 1){ //홀수일 경우
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }

        answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i];
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}