import java.io.*;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int k) {
        int[] answer = {};
        answer = new int[n+1];
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            if(i % k == 0){
                answer[cnt++] = i;
            }
        }

        answer = Arrays.copyOfRange(answer, 0, cnt);

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}