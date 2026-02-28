import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int count = 0;

        for(int n : number) count += n;

        // 제품과 수를 해시맵에 저장
        for(int i = 0; i < want.length; i++){
            hm.put(want[i], number[i]);
        }

        int length = discount.length - count + 1;
        for(int i = 0; i < length; i++){
            // 수량 일치 확인을 위한 샘플 생성
            HashMap<String, Integer> temp = new HashMap<>(hm);
            for(int j = i; j < i + count; j++){
//                System.out.print(discount[j] + " ");
                if(temp.containsKey(discount[j])){
                    if(temp.get(discount[j]) == 0) continue;
                    else {
                        temp.put(discount[j], temp.get(discount[j]) - 1);
                    }
                }
            }
//            System.out.println(temp);

            // 수량 일치하는지 확인
            boolean flag = true;
            for(Map.Entry<String, Integer> entry : temp.entrySet()){
                if(entry.getValue() != 0) {
                    flag = false;
                    break;
                }
            }
            // 수량이 다 맞을때
            if(flag) answer++;
        }

        return answer;
    }
}