package experiment2;

public abstract class Bird {
    public abstract void flying();

    public abstract void nesting();

    public abstract void eating();

    public abstract void singing();
}


class Eagle extends Bird {
    @Override
    public void flying() {
        System.out.println("Eagle is flying");
    }

    @Override
    public void nesting() {
        System.out.println("Eagle is nesting");
    }

    @Override
    public void eating() {
        System.out.println("Eagle is eating");
    }

    @Override
    public void singing() {
        System.out.println("Eagle is singing");
    }
}

class Dove extends Bird {
    @Override
    public void flying() {
        System.out.println("Dove is flying");
    }

    @Override
    public void nesting() {
        System.out.println("Dove is nesting");
    }

    @Override
    public void eating() {
        System.out.println("Dove is eating");
    }

    @Override
    public void singing() {
        System.out.println("Dove is singing");
    }
}

class Sparrow extends Bird {
    @Override
    public void flying() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void nesting() {
        System.out.println("Sparrow is nesting");
    }

    @Override
    public void eating() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void singing() {
        System.out.println("Sparrow is singing");
    }
}

class BirdExample {
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird dove = new Dove();
        Bird sparrow = new Sparrow();

        eagle.flying();
        eagle.nesting();
        eagle.eating();
        eagle.singing();

        dove.flying();
        dove.nesting();
        dove.eating();
        dove.singing();

        sparrow.flying();
        sparrow.nesting();
        sparrow.eating();
        sparrow.singing();
    }
}