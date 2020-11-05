import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        int count = 1;
        try {
            var result = (Callable) callable.call();
            return count += determineCallableDepth(result);
        } catch (Exception e) {
            return count;
        }
    }

}
