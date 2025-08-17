import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        sc.close(); 

        int lcm = 60;

        for (int year = X; year <= Y; year += lcm) {
            System.out.println("All positions change in year " + year);
        }
    }
}
