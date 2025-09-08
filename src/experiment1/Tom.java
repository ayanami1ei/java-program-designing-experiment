package experiment1;

public class Tom{
    int leg;
    String head;
    void cry(String s){
        System.out.println(s);
    }
}
class Example{
    public static void main(String args[])
    {  Tom cat;
        cat=new Tom();
        cat.leg=4;
        cat.head="猫头";
        System.out.println("腿:"+cat.leg+"条");
        System.out.println("头:"+cat.head);
        cat.cry("我今天要和Jerry拼了");
    }
}

/*
public class Tom {
    final int MAX=100;//设置成员变量
    final static int MIN=20;//设置静态成员变量
}
class Example4_3{

    public static void main(String[] args) {
        System.out.println(Tom.MIN);//静态成员变量可以直接被静态函数访问
        //System.out.println(Tom.MAX);// Error // 非静态成员变量不可以直接被静态函数访问
        Tom cat =new Tom();
        System.out.println(cat.MAX);// 非静态成员变量需要通过对象才能被静态函数访问
    }
}
*/
