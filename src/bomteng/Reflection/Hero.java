package bomteng.Reflection;

public class Hero {
    private String name = "王林";
    public int level = 1;

    public Hero() {}
    private Hero(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void attack(String skill) {
        System.out.println(name + " 使用了技能：" + skill);
    }

    private void secret() {
        System.out.println("我的境界是：death");
    }
}
