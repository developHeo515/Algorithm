class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        int length = (int)(right - left) + 1;

        answer = new int[length];
        int row = 0;
        int col = 0;
        long idx = 0;
        for(int size = 0; size < length; size++){
            idx = left + size;
            row = (int) (idx / n);
            col = (int) (idx % n);
            answer[size] = Math.max(row, col) + 1;
        }

        return answer;
    }
}
