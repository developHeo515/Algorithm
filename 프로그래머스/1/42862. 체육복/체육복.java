import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n+1];

        //초기값 설정
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }
        //도난 발생
        for(int num : lost){
            arr[num] = -1;
        }

        //오름차순으로 정렬해줘야 왼쪽부터 빌려주는게 성립됨
        Arrays.sort(reserve);
        //2벌 있는데 본인꺼 도난 당했을때
        for(int num : reserve){
            if(arr[num] == -1){
                arr[num] = 0;
            }
        }

        //여벌 체육복 가져온 사람
        for(int num : reserve){
            //본인도 도난 당했을 경우 여벌 체육복은 본인이 입어야함
            if(arr[num] == 0){
                continue;
            }
            boolean flag = true;

            //2벌 다 있을 경우
            int left = num - 1;
            int right = num + 1;
            if(1 <= left) {
                if(arr[left] == -1){
                    arr[left] = 0;
                    flag = false;
                }
            }
            if(flag){
                if(right <= n){
                    if(arr[right] == -1){
                        arr[right] = 0;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(arr));
        for(int i = 1; i <= n; i++){
            if(arr[i] != -1){
                answer++;
            }
        }
        
        return answer;
    }
}