import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        var list = stream.collect(Collectors.toList());
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            var orderedList = list.stream().sorted(order).collect(Collectors.toList());
            minMaxConsumer.accept(orderedList.get(0), orderedList.get(orderedList.size()-1));
        }


    }
}
