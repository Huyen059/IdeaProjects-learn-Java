import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamUtils {

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        return Stream.iterate(0, i -> i + 1)
                .limit(n)
                .mapToInt(num -> (int) Math.pow(2, num))
                .boxed();
    }
}
