class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};

        int length = (int)(right - left) + 1;
        answer = new int[length];
        int row = 0;
        int col = 0;
        for(int idx = 0; idx < length; idx++){
            long index = idx + left;
            row = (int) (index / n);
            col = (int) (index % n);
            answer[idx] = Math.max(row, col) + 1;
        }

        return answer;
    }
}