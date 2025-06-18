import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        for(int i = intervals[0][0]; i <= intervals[0][1]; i++){
            list.add(arr[i]);
        }
        for(int i = intervals[1][0]; i <= intervals[1][1]; i++){
            list.add(arr[i]);
        }


        //1번째 - MZ한 1줄로 푸는 방법
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        //2번째 - 근본 for문 방법
//        answer = new int[list.size()];
//        for(int i = 0; i < list.size(); i++){
//            answer[i] = list.get(i);
//        }

        // System.out.println(Arrays.toString(answer));

        return answer;
    }
}