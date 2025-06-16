import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        String str = "";
        boolean flag;
        for(int i = l; i <= r; i++){
            flag = true;
            str = String.valueOf(i);

            for(char c : str.toCharArray()){
                if(c != '0' && c != '5'){
                    flag = false;
                }
            }
            if(flag == true){
                list.add(i);
            }
        }

        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
            
            return answer;
        }

        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}