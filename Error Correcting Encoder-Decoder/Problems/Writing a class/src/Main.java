//write code of the Shelf class here
class Shelf<T extends Book> {
    T t;

    T getElement() {
        return t;
    }

    void setElement(T t) {
        this.t = t;
    }
}