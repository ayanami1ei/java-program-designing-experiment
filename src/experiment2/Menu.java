package experiment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Double> menu = new HashMap<>();
    private Map<String, Integer> order = new HashMap<>();

    public Menu() {
        menu.put("北京烤鸭", 299.1);
        menu.put("西芹炒肉", 32.9);
        menu.put("酸菜鱼", 79.0);
        menu.put("铁板牛柳", 42.1);
    }

    public void getOrder(Scanner sc) {
        int n = sc.nextInt();
        while (n != 0) {
            --n;
            order.merge(sc.next(), 1, Integer::sum);
        }
    }

    public double totalPrice() {
        double res = 0.0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            res += entry.getValue() * menu.get(entry.getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        menu.getOrder(sc);
        System.out.printf("总价格：%.1f元\n", menu.totalPrice());

        sc.close();
    }
}

