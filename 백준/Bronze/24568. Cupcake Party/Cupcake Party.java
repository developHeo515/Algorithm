import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int BIG_BOX_CAPACITY = 8;
        final int SMALL_BOX_CAPACITY = 3;
        final int PUPIL_SIZE = 28;

        final int bigBoxSize = Integer.parseInt(br.readLine());
        final int smallBoxSize = Integer.parseInt(br.readLine());

        int cupcakeSize = bigBoxSize * BIG_BOX_CAPACITY + smallBoxSize * SMALL_BOX_CAPACITY - PUPIL_SIZE;
        if (cupcakeSize < 0) {
            cupcakeSize = 0;
        }
        System.out.print(cupcakeSize);

    }
}