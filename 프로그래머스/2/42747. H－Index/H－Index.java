import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int h = 1; h < citations[citations.length-1]; h++){
            int cnt = 0;

            //1부터 논문 최대 인용 수
            for(int j = 0; j < citations.length; j++){
                // h번 이상 인용된 논문
                if(h <= citations[j]){
                    cnt++;
                }

//                System.out.println("인용수(h): " + h + " - cita : " + citations[j] + "  cnt: " + cnt);
                if(cnt >= h) {
//                    System.out.println(h + " - " + cnt + "======");
                    answer = h;
                    break;
                }
            }
        }

        return answer;
    }
}