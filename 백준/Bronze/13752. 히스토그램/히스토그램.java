import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            int k = sc.nextInt();
            
            for (int j = 1; j <= k; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}