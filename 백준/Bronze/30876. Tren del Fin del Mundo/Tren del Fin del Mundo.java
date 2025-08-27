import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int ansX = 2000000000;
        int ansY = 2000000000;
        
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if (y < ansY) {
                ansX = x;
                ansY = y;
            }
        }
        
        System.out.println(ansX + " " + ansY);
        scanner.close();
    }
}