import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<Character> list = new LinkedList<>();
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> li = list.listIterator(list.size());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String edit = st.nextToken();

            if (edit.equals("P")) {
                char ch = st.nextToken().charAt(0);
                li.add(ch);
            } else if (edit.equals("L")) {
                if (li.hasPrevious()) {
                    li.previous();
                }
            } else if (edit.equals("D")) {
                if (li.hasNext()) {
                    li.next();
                }
            } else if (edit.equals("B")) {
                if (li.hasPrevious()) {
                    li.previous();
                    li.remove();
                }
            }
        }

        while (li.hasPrevious()) {
            li.previous();
        }

        while (li.hasNext()) {
            bw.write(li.next());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}