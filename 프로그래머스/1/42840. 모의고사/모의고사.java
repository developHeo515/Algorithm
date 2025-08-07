import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] math1 = {1,2,3,4,5};
        int[] math2 = {2,1,2,3,2,4,2,5};
        int[] math3 = {3,3,1,1,2,2,4,4,5,5};
        int[] student = new int[3];

        int cnt;

        cnt = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == math1[i % math1.length]){
                cnt++;
            }
        }
        student[0] = cnt;

        cnt = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == math2[i % math2.length]){
                cnt++;
            }
        }
        student[1] = cnt;

        cnt = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == math3[i % math3.length]){
                cnt++;
            }
        }
        student[2] = cnt;

//        System.out.println(Arrays.toString(student));
        int max = 0;
        for(int i = 0; i < student.length; i++){
            if(max < student[i]){
                max = student[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < student.length; i++){
            if(max == student[i]){
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}