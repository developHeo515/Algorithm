import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for(int i = 0; i < prices.length; i++){
            int stock = prices[i];
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;
                if(stock > prices[j]) break;
            }
//            System.out.print(cnt + " ");
        }

        return answer;
    }
}