import java.util.*;
 
public class Main {
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K;
        int Young = 0, Min = 0;
        for (int i = 0; i < N; i++) {
            K = sc.nextInt();
            Young += ((K / 30) + 1) * 10;
            Min += ((K / 60) + 1) * 15;
 
        }
        if (Young == Min) {
            System.out.println("Y M " + Young);
        } else if (Young < Min) {
            System.out.println("Y " + Young);
        } else if (Young > Min) {
            System.out.println("M " + Min);
        }
    }
}
