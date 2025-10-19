package experiment2;

import java.util.*;

public class Person {
    private String name;
    private double weight, height;

    public void in(Scanner sc) {
        name = sc.next();
        weight = sc.nextDouble();
        height = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "姓名:" + name + "\n" +
                "体重:" + String.valueOf(weight) + "kg\n" +
                "身高:" + String.valueOf(height) + "m\n";
    }

    public static void main(String[] args) {
        Person p = new Person();
        Scanner sc = new Scanner(System.in);

        p.in(sc);
        System.out.println(p);

        sc.close();
    }
}
