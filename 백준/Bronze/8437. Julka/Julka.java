import java.io.*;
import java.math.BigInteger;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger total = new BigInteger(bf.readLine());
        BigInteger diff = new BigInteger(bf.readLine());
        BigInteger two = new BigInteger("2");
        
        BigInteger klaudia = (total.subtract(diff)).divide(two).add(diff);
        BigInteger natalia = (total.subtract(diff)).divide(two); 
        
        System.out.println(klaudia);
        System.out.println(natalia);
 
    }
 
}