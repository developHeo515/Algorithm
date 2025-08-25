import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int top = Integer.parseInt(br.readLine());
        int middle = Integer.parseInt(br.readLine());
        int bottom = Integer.parseInt(br.readLine());
        int coke = Integer.parseInt(br.readLine());
        int sider = Integer.parseInt(br.readLine());

        int minBurger = Math.min(top, Math.min(middle, bottom));
        int minDrink = Math.min(coke, sider);
        
        int result = minBurger + minDrink - 50;
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
