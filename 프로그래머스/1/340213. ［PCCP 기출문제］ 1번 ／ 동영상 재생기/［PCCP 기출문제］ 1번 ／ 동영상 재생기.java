class Solution {
    static int MM;
    static int SS;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

//        System.out.println(video_len.split(":")[0] + " " + video_len.split(":")[1]);
        int vl = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int p = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int opStart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);

//        System.out.println(p);
        if(opStart <= p && p <= opEnd){
            p = opEnd;
        }

        for(String command : commands){
            if(command.equals("next")){
                p += 10;
                if(vl < p){
                    p = vl;
                }
            }
            else if(command.equals("prev")){
                p -= 10;
                if(p < 0){
                    p = 0;
                }
            }
            
            if(opStart <= p && p <= opEnd){
                p = opEnd;
            }
        }
//        System.out.println(p);

        String MM = "";
        String SS = "";
        MM += p / 60;
        SS += p % 60;

        if(MM.length() == 1){
            MM = "0" + MM;
        }
        if(SS.length() == 1){
            SS = "0" + SS;
        }

//        System.out.println(MM + " " + SS);
        answer = MM + ":" + SS;
        return answer;
    }
}