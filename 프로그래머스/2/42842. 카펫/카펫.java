class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for(int col = 3; col <= total / 3; col++){
            //가로(row) >= 세로(col) 이라서 이렇게 함
            for(int row = col; row <= total / 3; row++){
                if(row * col != total) continue;
                else {
                    if((row - 2) * (col - 2) == yellow){
                        answer[0] = row;
                        answer[1] = col;
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}