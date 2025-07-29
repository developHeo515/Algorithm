class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = n/w + 1;
        int[][] box = new int[height + 1][w+1];
        boolean right = true;
        int boxNum = 1;

        for(int i = 1; i <= height; i++){

            if(right){
                for(int j = 1; j <= w; j++){
                    box[i][j] = boxNum++;
                }
            }
            else {
                for(int j = w; j >= 1; j--){
                    box[i][j] = boxNum++;
                }
            }
            //쌓는 방향 전환
            right = !right;
        }

        //택배 상자 위치 찾기
        int boxX = 0;
        int boxY = 0;
        boolean flag = true;
        for(int i = 1; i <= height; i++){
            if(flag){
                for(int j = 1; j <= w; j++){
//                System.out.print(box[i][j] + " ");
                    if(box[i][j] == num){
                        boxX = i;
                        boxY = j;
                        flag = false;
                        break;
                    }
                }
//            System.out.println();
            }
            else{
                break;
            }
        }

        //상자 몇개 쌓였는지 찾기
        for(int i = boxX; i <= height; i++){
//            System.out.print(box[i][boxY] + " - ");
            if(box[i][boxY] <= n){
                answer++;
            }
        }

        return answer;
    }
}