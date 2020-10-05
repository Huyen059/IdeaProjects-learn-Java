import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuilder input = new StringBuilder();
        int current = reader.read();
        while (current != -1) {
            input.append((char) current);
            current = reader.read();
        }

        System.out.println(input.reverse().toString());
        reader.close();
    }
}