import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger n=sc.nextBigInteger();

        BigInteger answer=new BigInteger("1");
        for(int i=2;i<=n.intValue();i++){
            answer=answer.multiply(BigInteger.valueOf(i));
            answer=answer.remainder(new BigInteger("10"));
        }

        System.out.println(answer);
    }
}