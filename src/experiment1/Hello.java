package experiment1;

class A
{
    void f()
    {
        //打印"I am A"
        System.out.println("I am A");
    }
}
class B
{
}
public class Hello
{
    public static void main (String args[ ])
    {
        //打印"你好，很高兴学习Java"
        System.out.println("你好，很高兴学习Java");
        //生成A对象
        A a=new A();
        //调用a的f方法
        a.f();
    }
}
