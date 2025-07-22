import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String strA = LSB(a);
        String strB = LSB(b);
        String strC = LSB(c);
        String strSum = "";

        strSum = strA + strB + strC;

        //이어붙인 이진수에서 앞에 0 제거
        int subIdx = 0;
        for(int i = 0; i < strSum.length(); i++){
            if(strSum.charAt(i) == '1'){
                subIdx = i;
                break;
            }
        }
        strSum = strSum.substring(subIdx);
//        System.out.println(strSum);

        //이진수를 십진수로 변환
        //방법 1. 메서드 사용
//        int res = Integer.parseInt(strSum, 2);
        //방법 2. 쌩구현
        int res = 0;
        int idx = strSum.length()-1;
        int convert = 1;
        while(idx >= 0){
            res += ((int)strSum.charAt(idx) - 48) * convert;
//            System.out.println(((int)strSum.charAt(idx) - 48) + " " + convert + " "+ res);
            convert = convert * 2;
            idx--;
        }
        String result = "" + res;
        while(result.length() < 4){
            result = "0" + result;
        }
//        System.out.println("이진수 " + strSum);
//        System.out.println("십진수 " + result);


        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static String LSB(int num){
        String str = "";
        //방법 1. 메서드로 딸깍하는 방법
//        str = Integer.toBinaryString(num);

        //방법 2. 그냥 쌩구현
        int remain = 0;
        while(num > 0){
            remain = num % 2;
            str = remain + str;
            num /= 2;
        }

        while(str.length() < 4){
            str = "0" + str;
        }

        str = str.substring(str.length() - 4);

        return str;
    }
}
