import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        List<Long> list = new ArrayList<>();
        for (long i = fromInclusive - 1; i < toExclusive; i++) {
            list.add(i);
        }

        int currentSize = list.size();

        return new Iterator<Long>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize - 1;
            }

            @Override
            public Long next() {
                currentIndex++;
                return list.get(currentIndex);
            }
        };
    }
}
