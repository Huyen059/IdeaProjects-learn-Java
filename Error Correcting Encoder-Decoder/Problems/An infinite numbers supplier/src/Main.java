import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<Integer>() {
            private Integer number = 0;
            @Override
            public Integer get() {
                number++;
                return number - 1;
            }
        };
    }

}
