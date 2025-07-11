import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int num : numArr){
            int sum = 0;
            for(int i = 1; i < num; i++){
                if(num % i == 0)
                    sum += i;
            }

            if(num > sum)
                bw.write("Deficient" + "\n");
            else if(num == sum)
                bw.write("Perfect" + "\n");
            else
                bw.write("Abundant" + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
