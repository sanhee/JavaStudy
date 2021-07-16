package Generics;

public class MyGenerics<T extends SanHee> {
    private final T element;

    public MyGenerics(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
