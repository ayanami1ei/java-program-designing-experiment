package experiment1;

//圆形类
public class Circle {
    // 声明radius
    double radius;
    //获取面积方法
    double getArea(){
        //面积公式：面积=pi*半径的平方
        double area =3.14*radius*radius;
        //返回面积
        return area;
    }

}


class Example4 {
    public static void main(String[] args) {
        //声明圆形对象
        Circle circle;
        //创建圆形对象
        circle = new Circle();
        //设置圆形半径
        circle.radius = 1;
        //调用获取面积方法
        double area=circle.getArea();
        //打印面积
        System.out.println(area);
    }
}

