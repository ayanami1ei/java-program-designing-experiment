package experiment2.Example;

import experiment2.cn.edu.College;
import experiment2.cn.edu.SZU;

public class SZUExample {
    public static void main(String[] args) {
        SZU szu = new SZU();

        szu.addCollege(new College("计算机与软件学院"));
        szu.addCollege(new College("物理与光电学院"));

        szu.getCollegeNames();
        szu.getCollegeNumber();
    }
}
