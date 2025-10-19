package experiment2.cn.edu;

import java.util.ArrayList;
import java.util.List;

public class SZU {
    private List<College> colleges = new ArrayList<>();

    public void getCollegeNames() {
        System.out.println("深圳大学的学院有：");
        for (College c : colleges) {
            System.out.println("- " + c.getName());
        }
        System.out.println();
    }

    public void getCollegeNumber() {
        System.out.println("深圳大学的学院有" + colleges.size() + "个");
    }

    public void addCollege(College newCollege) {
        colleges.add(newCollege);
    }

    public static void main(String[] args) {
        SZU szu = new SZU();

        szu.addCollege(new College("计算机与软件学院"));
        szu.addCollege(new College("物理与光电学院"));

        szu.getCollegeNames();
        szu.getCollegeNumber();
    }
}


