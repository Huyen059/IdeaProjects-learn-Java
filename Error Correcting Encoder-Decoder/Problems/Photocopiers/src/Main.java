/**
 * Class to work with
 */
class Multiplicator {

	public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
		// Method to implement
        Folder<T>[] list = new Folder[arraySize];
        if (folder.get() instanceof Copy) {
            for (int i = 0; i < arraySize; i++) {
                var newF = new Folder<T>();
                newF.put(folder.get().copy());
                list[i] = newF;

            }
        }
        return list;
	}

}

// Don't change the code below
interface Copy<T> {
	T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }
}
