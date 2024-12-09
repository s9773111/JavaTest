package bomteng.book.Object;

public class ch04Field {
    public static void main(String[] args) {
        var sun = new Clothes();
        var spring = new Clothes();

        sun.color = "red";
        sun.size = 'S';
        spring.color = "green";
        spring.size = 'M';

        System.out.printf("sun (%s, %c)%n", sun.color, sun.size);
        System.out.printf("spring (%s, %c)%n", spring.color, sun.size);

        var sun2 = new Clothes("blue", 'M');
        var spring2 = new Clothes("yellow", 'L');
        System.out.printf("sun2 (%s, %c)%n", sun2.color, sun2.size);
        System.out.printf("spring2 (%s, %c)%n", spring2.color, sun2.size);

    }
}

class Clothes {

    String color;
    char size;

    public Clothes(String color, char size) {
        this.color = color;
        this.size = size;
    }

    public Clothes() {
    }
}
