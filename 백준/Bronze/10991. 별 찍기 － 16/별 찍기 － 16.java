import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println("*");
        }
        else{
            for(int i = 1; i <= n; i++){
                for(int b = i; b < n; b++){
                    System.out.print(" ");
                }
                for(int k = 1; k <= i; k++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


}
