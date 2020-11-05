import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


class Operator {

    public static UnaryOperator<List<String>> unaryOperator = (List<String> list) -> list.stream().distinct().collect(Collectors.toList());
}
