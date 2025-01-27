package bomteng.Generics;

public class GenericsTest1 {
    public static void main(String[] args) {
        // 使用泛型方法1 Integer
        Integer[] intArray = {1,2,3,4,5};
        printArray(intArray);

        // 使用泛型方法1 String
        String[] stringArray = {"Hello", "World"};
        printArray(stringArray);

        // 使用泛型介面2
        Box<Integer> box = new IntegerBox();
        box.add(10);
        Integer value = box.get();
        System.out.println("box值為：" + value);

        // 使用泛型介面3
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.add(100);
        Integer intValue = intBox.get();
        System.out.println("Integer Value: " + intValue);

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.add("Hello, Generic!");
        String strValue = stringBox.get();
        System.out.println("String Value: " + strValue);

        // 使用泛型介面3 - 自定義
        GenericBox<Person> personBox = new GenericBox<>();
        personBox.add(new Person("Alice"));
        Person person = personBox.get();
        System.out.println("Person: " + person);

    }

    // 定義泛型方法
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

