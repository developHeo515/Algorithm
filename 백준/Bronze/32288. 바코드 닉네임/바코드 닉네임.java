import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = str.replace('I', 'i');
        str = str.replace('l', 'L');
        bw.write(str + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
