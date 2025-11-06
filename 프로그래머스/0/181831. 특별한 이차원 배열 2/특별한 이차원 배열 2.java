class Solution {
    public int solution(int[][] arr) {
        int answer = 0;

        boolean flag = true;
        for(int i = 0; i < arr.length; i++){
            if(flag == false){
                break;
            }
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != arr[j][i]){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            answer = 1;
        }
        else {
            answer = 0;
        }

        return answer;
    }
}