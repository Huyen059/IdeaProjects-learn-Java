import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(String.join("", words));
            return writer.toCharArray();
        }
    }
}