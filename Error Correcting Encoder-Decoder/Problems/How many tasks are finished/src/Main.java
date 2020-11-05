import java.util.*;
import java.util.concurrent.*;


class FutureUtils {

    public static int howManyIsDone(List<Future> items) {
        int count = 0;
        for (var item: items) {
            if (item.isDone()) {
                count++;
            }
        }
        return count;
    }

}
