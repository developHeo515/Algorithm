import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int n : nums){
            hs.add(n);
        }

//        System.out.println(hs.size() + " " + nums.length / 2);
        if(hs.size() < nums.length / 2){
            answer = hs.size();
        }else{
            answer = nums.length / 2;
        }

        return answer;
    }
}