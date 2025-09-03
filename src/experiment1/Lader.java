package experiment1;

public class Lader {
    double above, bottom, height;//三个私有成员变量

    Lader() {}//无参构造函数

    Lader(double a, double b, double h) {//含参构造函数
        above = a;
        bottom = b;
        height = h;//三个参数分别给三个变量赋值
    }

    public void setAbove(double a) {//设置above
        above = a;
    }

    public void setBottom(double b) {//设置bottom
        bottom = b;
    }

    public void setHeight(double h) {//设置height
        height = h;
    }

    double computeArea() {//面积计算方法
        return (above+bottom)*height/2.0;
    }
}
class Example4_1 {
    public static void main(String[] args){
        double area1=0,area2=0;//初始化面积
        Lader laderOne,laderTwo;//声明对象
        laderOne=new Lader();//使用默认构造函数创建对象
        laderTwo=new Lader(10,88,20);//使用含参构造函数创建对象
        laderOne.setAbove(16);
        laderOne.setBottom(26);
        laderOne.setHeight(100);
        laderTwo.setAbove(300);
        laderTwo.setBottom(500);//通过方法设置对象的参数
        area1=laderOne.computeArea();
        area2=laderTwo.computeArea();//通过面积计算方法计算面积
        System.out.println(area1);
        System.out.println(area2);//输出面积
    }
}