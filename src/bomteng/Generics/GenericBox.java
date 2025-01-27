package bomteng.Generics;

// 實現介面2-保留泛型型態參數，保持靈活性
public class GenericBox<T> implements Box<T> {
    private T item;
    @Override
    public void add(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }
}
