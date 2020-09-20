public class Main {

    public static void main(String[] args) {
        Secret[] values = Secret.values();
        int count = 0;
        for (Secret value: values) {
            if (String.valueOf(value.name().toCharArray(), 0, 4).equals("STAR")) {
                count++;
            }
        }
        System.out.println(count);
    }
}


