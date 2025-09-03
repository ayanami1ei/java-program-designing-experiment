package experiment1;

public class Circle {//圆形类
    double radius;//声明radius
    double getArea(){//获取面积方法
        double area =3.14*radius*radius;//面积公式：面积=pi*半径的平方
        return area;//返回面积
    }

}


class Example4 {
    public static void main(String[] args) {//程序入口
        Circle circle;//声明圆形对象
        circle = new Circle();//创建圆形对象
        circle.radius = 1;//设置圆形半径
        double area=circle.getArea();//调用获取面积方法
        System.out.println(area);//打印面积
    }
}