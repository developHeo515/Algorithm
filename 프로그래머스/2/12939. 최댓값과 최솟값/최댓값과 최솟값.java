class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int num = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(String a : str){
            num = Integer.parseInt(a);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return answer = min + " " + max;
    }
}