class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 3; i <= total; i++) {
            int col = i;
            int row = total / col;

            if (row < 3) {
                continue;
            }

            if (row >= col) {
                if ((row - 2) * (col - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}