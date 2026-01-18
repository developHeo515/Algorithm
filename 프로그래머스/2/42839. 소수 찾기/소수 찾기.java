import java.util.HashSet;

class Solution {
    static int cnt;
    public int solution(String numbers) {
        int answer = 0;
        char[] arr = new char[numbers.length()];
        boolean[] visit = new boolean[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }

        cnt = 0;
        String str = "";
        HashSet<Integer> hm = new HashSet<>();
        dfs(arr, visit, str, hm);

//        System.out.println("==========");
        answer = cnt;

        return answer;
    }

    static void dfs(char[] arr, boolean[] visit, String str, HashSet<Integer> hm){
        if(str.length() != 0){
            int num = Integer.parseInt(str);
            // 처음 나온 숫자들만 체크한다.
            if(!hm.contains(num)){
                //소수인지 체크
                boolean abc = isPrime(num);
                if(abc) {
                    cnt++;
                }

                hm.add(num);
//                System.out.println(num + " == " + abc);
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                str += arr[i];
                dfs(arr, visit, str, hm);
                str = str.substring(0, str.length() - 1);
                visit[i] = false;
            }
        }
    }

    static boolean isPrime(Integer num){
        if(num < 2) return false;

        boolean flag = true;

        for(int i = 2; i < num; i ++){
            // 1과 자기 자신을 제외한 수로 나눠지면 소수가 아니라서 false 해준다.
            if(num % i == 0){
                flag = false;
            }
        }

        return flag;
    }
}