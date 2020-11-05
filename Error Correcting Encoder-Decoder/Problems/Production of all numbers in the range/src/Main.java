import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator =
            (long a, long b) -> {
                long product = 1L;
                for (long i = a; i <= b; i++) {
                    product *= i;
                }
                return product;
            };
}
