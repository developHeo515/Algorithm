import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();

//        System.out.println(my_str);
        int cnt = 0;
        String str = "";
        for(int i = 0; i < my_str.length(); i++){
            cnt++;
            str += my_str.charAt(i);
//            System.out.println(my_str.charAt(i));
            if(cnt == n){
                list.add(str);
                str = "";
                cnt = 0;
            }
        }

        if(cnt != 0){
            list.add(str);
        }

        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
            answer[i] = list.get(i);
        }

        return answer;
    }
}