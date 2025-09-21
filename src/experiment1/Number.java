package experiment1;

import java.util.Scanner;

/*用户从键盘输入1个正整数
程序逆序打印出该正整数的各位数字（例如：某个正整数为123456，程序输出654321）
要求在不终止程序的情况下能循环10次从键盘读入*/

public class Number {
    //原始数字
    private String n;
    //StringBuilder工具
    private StringBuilder sb;

    //输入函数并转为字符串
    public void in(Scanner sc) {
        n = sc.next();
        sb = new StringBuilder(n);
    }

    //字符串反转并输出
    public void reverse(){
        sb.reverse();
        n=sb.toString();
        System.out.println(n);
    }

    //输出原始数据
    public void out(){
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Number n=new Number();

        for (int i=0;i<10;++i){
            n.in(sc);
            n.out();
            n.reverse();
        }

        sc.close();
    }
}
