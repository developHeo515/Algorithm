import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String answer = "";

        for(int i = 0; i < str.length(); i++){
//            System.out.println(str.charAt(i));
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)){
                answer += Character.toLowerCase(ch);
            }
            else if(Character.isLowerCase(ch)){
                answer += Character.toUpperCase(ch);
            }
        }

        System.out.println(answer);
    }
}