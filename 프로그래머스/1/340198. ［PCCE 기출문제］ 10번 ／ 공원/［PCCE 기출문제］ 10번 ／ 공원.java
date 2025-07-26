import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Integer[] arr = new Integer[mats.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = mats[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());
        boolean flag;

        for(int mat : arr){
            for(int i = 0; i <= park.length-mat; i++){
                for(int j = 0; j <= park[0].length-mat; j++){
                    if(park[i][j].equals("-1")){
                        flag = true;

                        //돗자리 자리 탐색 시작
                        for(int x = i; x < i + mat; x++){
                            for(int y = j; y < j + mat; y++){
                                if(!park[x][y].equals("-1")){
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag == false) break;
                        }
                        //다 통과됐으니 retrun 해주기
                        if(flag == true){
                            return mat;
                        }
                    }
                }
            }
        }

        answer = -1;
        return answer;
    }
}