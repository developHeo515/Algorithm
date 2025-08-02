class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            int day = startday;
            int eventNum = 0;
            int schedule = (schedules[i] / 100 * 60) + (schedules[i] % 100) + 10;
            // System.out.println(schedule);
            for(int j = 0; j < 7; j++){
                if(day == 6){
                    day++;
                    continue;
                }
                else if(day == 7){
                    day = 1;
                    continue;
                }
                else{
                    int time = (timelogs[i][j] / 100 * 60) + (timelogs[i][j] % 100);
                    if(time <= schedule){
                        eventNum++;
                    }
                    day++;
                }
            }
            if(eventNum == 5){
                answer++;
            }
        }
        
        return answer;
    }
}