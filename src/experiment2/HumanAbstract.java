package experiment2;

public abstract class HumanAbstract {
    protected String name;

    public HumanAbstract(String name) {
        this.name = name;
    }

    public abstract double sayHello();
}

class Chinese extends HumanAbstract {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public double sayHello() {
        System.out.println("你好,我是" + name);
        return 0;
    }
}

class Japanese extends HumanAbstract {

    public Japanese(String name) {
        super(name);
    }

    @Override
    public double sayHello() {
        System.out.println("こにちは, 私は" + name);
        return 0;
    }
}

class English extends HumanAbstract {

    public English(String name) {
        super(name);
    }

    @Override
    public double sayHello() {
        System.out.println("Hello. I'm " + name);
        return 0;
    }
}

class HumanTest {
    public static void main(String[] args) {
        HumanAbstract[] people = new HumanAbstract[3];
        people[0] = new Chinese("李华");
        people[1] = new Japanese("ひな");
        people[2] = new English("Peter");

        for (var x : people) {
            x.sayHello();
        }
    }
}