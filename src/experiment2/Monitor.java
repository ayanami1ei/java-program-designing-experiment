package experiment2;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Monitor implements Comparable<Monitor> {
    private String name;
    private double size;
    private double price;

    public Monitor(String name, double size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "（" + size + "寸，￥" + price + "）";
    }

    @Override
    public int compareTo(Monitor other) {
        if (this.price == other.price) {
            return this.name.compareTo(other.name);
        }
        return Double.compare(this.price, other.price);
    }

    public static void main(String[] args) {
        TreeMap<Monitor, String> map1 = new TreeMap<>();

        map1.put(new Monitor("AOC", 23.8, 799), "国产品牌");
        map1.put(new Monitor("Samsung", 27, 1599), "韩系");
        map1.put(new Monitor("Dell", 24, 1099), "美系");
        map1.put(new Monitor("LG", 27, 1399), "韩系");
        map1.put(new Monitor("Asus", 25, 999), "台系");
        map1.put(new Monitor("HP", 27, 1199), "美系");
        map1.put(new Monitor("Xiaomi", 34, 1699), "国产品牌");
        map1.put(new Monitor("Lenovo", 23.8, 899), "国产品牌");

        System.out.println("实现Comparable接口");
        for (Map.Entry<Monitor, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        TreeMap<Monitor, String> map2 = new TreeMap<>(new PriceComparator());

        map2.put(new Monitor("AOC", 23.8, 799), "国产品牌");
        map2.put(new Monitor("Samsung", 27, 1599), "韩系");
        map2.put(new Monitor("Dell", 24, 1099), "美系");
        map2.put(new Monitor("LG", 27, 1399), "韩系");
        map2.put(new Monitor("Asus", 25, 999), "台系");
        map2.put(new Monitor("HP", 27, 1199), "美系");
        map2.put(new Monitor("Xiaomi", 34, 1699), "国产品牌");
        map2.put(new Monitor("Lenovo", 23.8, 899), "国产品牌");

        System.out.println("\n使用Comparator接口");
        for (Map.Entry<Monitor, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

class PriceComparator implements Comparator<Monitor> {
    @Override
    public int compare(Monitor m1, Monitor m2) {
        if (m1.getPrice() == m2.getPrice()) {
            return m1.getName().compareTo(m2.getName());
        }
        return Double.compare(m1.getPrice(), m2.getPrice());
    }
}