import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] numArr = new int[3];
        
        for (int i = 0; i < 3; i++) {
            numArr[i] = sc.nextInt();
        }
        
        Arrays.sort(numArr);
        
        System.out.print(numArr[1]);
 
    }
}