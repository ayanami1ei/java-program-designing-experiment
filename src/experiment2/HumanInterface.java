package experiment2;

public interface HumanInterface {
    double sayHello();

    String getName();

    void setName(String name);
}


class ChineseImpl implements HumanInterface {
    private String name;

    @Override
    public double sayHello() {
        System.out.println("你好,我是" + name);
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class JapaneseImpl implements HumanInterface {
    private String name;

    @Override
    public double sayHello() {
        System.out.println("こにちは, 私は" + name);
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class EnglishImpl implements HumanInterface {
    private String name;

    @Override
    public double sayHello() {
        System.out.println("Hello. I'm " + name);
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class HumanInterfaceTest {
    public static void main(String[] args) {
        HumanInterface chinese = new ChineseImpl();
        chinese.setName("李华");
        HumanInterface japanese = new JapaneseImpl();
        japanese.setName("ひな");
        HumanInterface english = new EnglishImpl();
        english.setName("Peter");

        chinese.sayHello();
        japanese.sayHello();
        english.sayHello();
    }
}