//BOJ6840 브5
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(num1);
        al.add(num2);
        al.add(num3);
        
        
        Collections.sort(al);
        System.out.println(al.get(1));
    }
}
