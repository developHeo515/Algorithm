
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            for(int j = n-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int k = 1; k < i*2; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1; i < n; i++){
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int j = (n-i) * 2; j > 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}