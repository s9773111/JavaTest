package bomteng.Generics;

// 實現介面1-具體的型態參數實現
public class IntegerBox implements Box<Integer>{

    private Integer item;

    @Override
    public void add(Integer item) {
        this.item = item;
    }

    @Override
    public Integer get() {
        return item;
    }
}
