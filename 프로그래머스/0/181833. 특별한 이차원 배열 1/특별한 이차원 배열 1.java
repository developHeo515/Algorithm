import java.io.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};

        answer = new int[n][n];

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    answer[i][j] = 1;
                }
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

        return answer;
    }
}