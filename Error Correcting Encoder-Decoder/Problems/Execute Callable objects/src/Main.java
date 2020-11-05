import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Integer result = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            var item = items.get(i);
            try {
                var task = item.get();
                var future = executor.submit(task);
                result += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }
        executor.shutdown();
        return result;
    }

}
