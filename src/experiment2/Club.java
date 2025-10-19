package experiment2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Club {
    private Set<String> clubA = new HashSet<>();
    private Set<String> clubB = new HashSet<>();

    public void input(Scanner sc) {
        System.out.println("请输入A社团成员（每行一个名字，空行结束）：");
        while (true) {
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                break;
            }
            clubA.add(name);
        }

        System.out.println("请输入B社团成员（每行一个名字，空行结束）：");
        while (true) {
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                break;
            }
            clubB.add(name);
        }
    }

    @Override
    public String toString() {
        Set<String> both = new HashSet<>(clubA);
        both.retainAll(clubB);
        return "A社团的成员有：" + clubA + "\nB社团的成员有：" + clubB +
                "\n同时参加两个社团的成员：" + both;
    }

    public static void main(String[] args) {
        Club club = new Club();
        Scanner sc = new Scanner(System.in);
        club.input(sc);
        System.out.println(club);
    }
}
