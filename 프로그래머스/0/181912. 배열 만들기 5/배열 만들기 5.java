import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        List<Integer> res = new ArrayList<>();

        for(String str : intStrs){
            String StrConvertInt = str.substring(s, s+l);
            int compareNum = Integer.parseInt(StrConvertInt);
            if(k < compareNum){
                res.add(compareNum);
            }
        }

        answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
            // System.out.println(answer[i]);
        }

        return answer;
    }
}