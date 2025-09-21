package experiment1;

public class Lader {
    //三个私有成员变量
    double above, height;
    //静态变量
    static double bottom;

    //无参构造函数
    Lader() {}

    //含参构造函数
    Lader(double a, double b, double h) {
        //三个参数分别给三个变量赋值
        above = a;
        bottom = b;
        height = h;
    }

    //设置above
    public void setAbove(double a) {
        above = a;
    }

    //设置bottom
    public void setBottom(double b) {
        bottom = b;
    }

    //设置height
    public void setHeight(double h) {
        height = h;
    }

    double getAbove(){
        return above;
    }
    double getBottom(){
        return bottom;
    }

    //面积计算方法
    double computeArea() {
        return (above+bottom)*height/2.0;
    }
}
/*
class Example4_1 {
    public static void main(String[] args){
        //初始化面积
        double area1=0,area2=0;
        //声明对象
        Lader laderOne,laderTwo;
        //使用默认构造函数创建对象
        laderOne=new Lader();
        //使用含参构造函数创建对象
        laderTwo=new Lader(10,88,20);
        //通过方法设置对象的参数
        laderOne.setAbove(16);
        laderOne.setBottom(26);
        laderOne.setHeight(100);
        laderTwo.setAbove(300);
        laderTwo.setBottom(500);
        //通过面积计算方法计算面积
        area1=laderOne.computeArea();
        area2=laderTwo.computeArea();
        //输出面积
        System.out.println(area1);
        System.out.println(area2);
    }
}

 */


class Example4_2
{
    public static void main(String[] args)
    {
        //设置按钮
        Lader.bottom=60;
        //声明对象
        Lader laderOne,laderTwo;
        //打印按钮
        System.out.println(Lader.bottom);
        //生成对象
        laderOne=new Lader();
        laderTwo=new Lader();
        //打印两个对象的按钮
        System.out.println(laderOne.getBottom());
        System.out.println(laderTwo.getBottom());

        //设置对象的成员变量
        laderOne.setAbove(11);
        laderTwo.setAbove(22);
        laderTwo.setBottom(100);

        //打印成员变量
        System.out.println(Lader.bottom);
        System.out.println(laderOne.getAbove());
        System.out.println(laderTwo.getAbove());
    }
}




