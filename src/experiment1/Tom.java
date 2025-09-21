package experiment1;

/*
public class Tom{
    //腿的数量
    int leg;
    //头的类型
    String head;

    //大喊方法
    void cry(String s){
        System.out.println(s);
    }
}
class Example{
    public static void main(String args[])
    {
        //声明Tom类型的cat
        Tom cat;
        //生成Tom对象
        cat=new Tom();
        //为成员变量赋值
        cat.leg=4;
        cat.head="猫头";
        //打印成员变量
        System.out.println("腿:"+cat.leg+"条");
        System.out.println("头:"+cat.head);
        //调用cry方法
        cat.cry("我今天要和Jerry拼了");
    }
}
 */

public class Tom {
    //设置成员变量
    final int MAX=100;
    //设置静态成员变量
    final static int MIN=20;
}
class Example4_3{

    public static void main(String[] args) {
        //静态成员变量可以直接被静态函数访问
        System.out.println(Tom.MIN);
        //非静态成员变量不可以直接被静态函数访问
        //System.out.println(Tom.MAX);// Error
        // 非静态成员变量需要通过对象才能被静态函数访问
        Tom cat =new Tom();
        System.out.println(cat.MAX);
    }
}

