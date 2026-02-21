import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        int[][] answer = {};
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);

        answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }

    static void hanoi(int n, int A, int B, int C){
        if(n == 1){
//            System.out.println(A + " -> " + C);
            list.add(new int[]{A, C});
            return;
        }

        hanoi(n-1, A, C, B);
        hanoi(1, A, B, C);
        hanoi(n-1, B, A, C);
    }
}
