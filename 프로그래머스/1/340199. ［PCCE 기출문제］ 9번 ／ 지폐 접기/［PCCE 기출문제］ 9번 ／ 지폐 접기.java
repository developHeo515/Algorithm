class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletMin = wallet[0] < wallet[1] ? wallet[0] : wallet[1];
        int walletMax = wallet[0] < wallet[1] ? wallet[1] : wallet[0];
        int billMin = bill[0] < bill[1] ? bill[0] : bill[1];
        int billMax = bill[0] < bill[1] ? bill[1] : bill[0];

        while(walletMin < billMin || walletMax < billMax){
            if(bill[0] < bill[1]){
                bill[1] /= 2;
            }
            else{
                bill[0] /= 2;
            }
            answer++;
            billMin = bill[0] < bill[1] ? bill[0] : bill[1];
            billMax = bill[0] < bill[1] ? bill[1] : bill[0];
        }

        return answer;
    }
}