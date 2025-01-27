package bomteng.Generics;

// 實現介面1-具體的型態參數實現
public interface Box<T> {
    void add(T item);
    T get();
}
