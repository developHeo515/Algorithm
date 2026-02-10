class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = getLcm(answer, arr[i]);
        }

        return answer;
    }

    // 최대공약수
    static int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수
    static int getLcm(int a, int b) {
        return (a * b) / getGcd(a, b);
    }
}