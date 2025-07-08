import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int num = n * (n-1) * (n-2) * (n-3) / 24;
        
        System.out.println(num);
    }
}