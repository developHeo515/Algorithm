import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            int size = str.length();
            int zero = 0;
            for(int j = 0; j < size; j++){
                if(str.charAt(j) >= 'A' && str.charAt(j) <= 'Z'){
                    zero += arr[str.charAt(j) - 'A'];
                }
            }
            bw.write(zero + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
