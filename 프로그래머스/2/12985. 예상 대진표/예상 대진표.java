class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int round = 1;
        a--;
        b--;
        while(a / 2 != b / 2){
            a /= 2;
            b /= 2;
            round++;
        }

        return answer = round;
    }
}