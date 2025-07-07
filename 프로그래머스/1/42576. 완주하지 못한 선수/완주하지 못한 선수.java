import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

//        System.out.println(Arrays.toString(participant));
//        System.out.println(Arrays.toString(completion));

        boolean search = false;
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                search = true;
                break;
            }
        }
        if(search == false){
            answer = participant[participant.length-1];
        }

        return answer;
    }
}