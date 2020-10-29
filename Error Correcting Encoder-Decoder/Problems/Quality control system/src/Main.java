import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

class QualityControl {

    public static boolean check(List<?> boxes) {

        for (Object box: boxes) {
            if (!(box instanceof Box)) {
                return false;
            }

            var item = ((Box<?>) box).get();
            if (!(item instanceof Bakery)) {
                return false;
            }
        }

        return true;
    }

}

// Don't change the code below
class Bakery { }

class Cake extends Bakery { }

class Pie extends Bakery { }

class Tart extends Bakery { }

class Paper { }

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}
