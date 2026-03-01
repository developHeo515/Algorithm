import java.util.*;

class Solution {
    static List<Long> numList = new ArrayList<>();
    static List<Character> chList = new ArrayList<>();
    static char[] operator = new char[3];
    static long ans;
    public long solution(String expression) {
        long answer = 0;

        long num = 0;
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                chList.add(ch);
                numList.add(num);
                num = 0;
            }
            else {
                num = num * 10 + ch - '0';
            }
        }
        numList.add(num);

        operator[0] = '+';
        operator[1] = '-';
        operator[2] = '*';
        ans = 0;
        purm(new ArrayList<>(), new boolean[3]);

        return answer = ans;
    }
    
    static void purm(List<Character> seq, boolean[] visit){
        if(seq.size() == 3){
            List<Long> numTmp = new ArrayList<>(numList);
            List<Character> chTmp =  new ArrayList<>(chList);
            for(char c : seq){
                for(int k = 0; k < chTmp.size(); k++){
                    // 우선순위 연산자 발견(계산해야함)
                    if(chTmp.get(k) == c){
                        long a = numTmp.get(k);
                        long b = numTmp.get(k+1);
                        numTmp.remove(k);
                        numTmp.remove(k);
                        chTmp.remove(k);

                        // 계산시작
                        if(c == '+'){
                            numTmp.add(k, a + b);
                        }
                        else if(c == '-'){
                            numTmp.add(k, a - b);
                        }
                        else if(c == '*'){
                            numTmp.add(k, a * b);
                        }
                        k--;
                    }
                }
            }
//            System.out.println(numTmp);
            ans = Math.max(ans, Math.abs(numTmp.get(0)));

            return;
        }

        for(int i = 0; i < 3; i++){
            if(!visit[i]){
                visit[i] = true;
                seq.add(operator[i]);
                purm(seq, visit);
                seq.remove(seq.size() - 1);
                visit[i] = false;
            }
        }
    }
}