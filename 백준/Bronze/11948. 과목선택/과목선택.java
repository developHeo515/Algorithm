import java.io.IOException;
import java.util.Scanner;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int tmp = sc.nextInt();
            sum += tmp;
            minFirst = Math.min(minFirst,tmp);
        }

        for (int i = 0; i < 2; i++) {
            int tmp = sc.nextInt();
            sum += tmp;
            minSecond = Math.min(minSecond,tmp);
        }
        sum-=minFirst;
        sum-=minSecond;
        System.out.println(sum);
    }
}