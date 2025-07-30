class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int forNum = t.length() - p.length() + 1;
        Long pNum = Long.parseLong(p);

        for(int i = 0; i < forNum; i++){
            Long num = Long.parseLong(t.substring(i, i + p.length()));
//            System.out.println(num);
            if(num <= pNum){
                answer++;
            }
        }

        return answer;
    }
}