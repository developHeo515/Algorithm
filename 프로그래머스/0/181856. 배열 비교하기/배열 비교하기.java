class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;

        if(arr1.length > arr2.length){
            return 1;
        }else if(arr1.length < arr2.length){
            return -1;
        }else {
            int a = 0;
            int b = 0;
            for(int i = 0; i < arr1.length; i++){
                a += arr1[i];
                b += arr2[i];
            }
            return Integer.compare(a, b);
        }
    }
}