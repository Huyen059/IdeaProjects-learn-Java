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
        String[] words = input.toString().trim().split("\\s+");
        boolean isEmpty = true;
        for (String word : words) {
            if (!word.isEmpty()) {
                isEmpty = false;
                break;
            }
        }

        if (!isEmpty) {
            System.out.println(words.length);
        } else {
            System.out.println(0);
        }
        reader.close();
    }
}