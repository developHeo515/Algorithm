import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<String, Integer> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        String name;
        String commute;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            commute = st.nextToken();
            if(commute.equals("enter")){
                hm.put(name, hm.getOrDefault(name, 0) + 1);
            }
            else if(commute.equals("leave")){
                hm.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
//            bw.write(entry.getKey() + " mm " + entry.getValue() + "\n");
            list.add(entry.getKey());
        }

        Collections.sort(list, Comparator.reverseOrder());
        for(String str : list){
            bw.write(str + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
