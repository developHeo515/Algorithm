import java.io.*;
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();

        for(int n : numbers){
            list.add(String.valueOf(n));
        }

        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        if(list.get(0).equals("0")){
            return "0";
        }

        for(String str : list) {
            answer += str;
        }

        return answer;
    }
}