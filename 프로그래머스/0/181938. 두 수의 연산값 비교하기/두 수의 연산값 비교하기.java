class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        String str = a + "" + b;
        int ab1 = Integer.parseInt(str);
        int ab2 = 2 * a * b;

//        System.out.println(ab1 + " " + ab2);
        if(ab1 >= ab2){
            answer = ab1;
        }
        else {
            answer = ab2;
        }

        return answer;
    }
}