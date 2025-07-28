import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int cnt;

        for(String[] pho : photo){
            cnt = 0;
            for(String p : pho){
                for(int i = 0; i < name.length; i++){
                    if(name[i].equals(p)){
                        cnt += yearning[i];
                        break;
                    }
                }
            }
            list.add(cnt);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}