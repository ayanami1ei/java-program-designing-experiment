package experiment1;

import java.util.Scanner;

/*用户从键盘输入1个正整数
程序逆序打印出该正整数的各位数字（例如：某个正整数为123456，程序输出654321）
要求在不终止程序的情况下能循环10次从键盘读入*/

public class Number {
    private int n;
    private StringBuilder sb;

    public void in(Scanner sc){//输入函数并转为字符串
        n=sc.nextInt();
        sb=new StringBuilder(String.valueOf(n));
    }

    public void reverse(){//字符串反转并输出
        sb.reverse();
        System.out.println(sb.toString());
    }

    public void out(){//输出原始数据
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Number n=new Number();
        for (int i=0;i<10;i++){
            n.in(sc);
            n.out();
            n.reverse();
        }
        sc.close();
    }
}
