import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        SortedMap<Integer, String> subMap;
        if (map.firstKey() % 2 != 0) {
            subMap = map.headMap(map.firstKey() + 5);
        } else {
            subMap = map.tailMap(map.lastKey() - 4);
        }

        Map<Integer, String> reverseSubMap = new TreeMap<>(Collections.reverseOrder());
        subMap.forEach(reverseSubMap::put);
        return reverseSubMap;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}