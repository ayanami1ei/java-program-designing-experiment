package experiment1;

import java.util.Scanner;

/*某省居民电价分三个“阶梯”：
月用电量50度以内的部分，电价为0.56元/度；
用电量在51度至220度之间的部分，电价为0.59元/度；
用电量超过220度的部分，电价为0.66元/度。
编写程序，用户从键盘输入用电量（要求在不终止程序的情况下能循环10次从键盘读入10个数字：58、52、230、70、80、89、510、60、1、10），程序输出用户应缴纳的电费。*/

public class Electricity {
    //总用电量和电费
    private double total,price;

    //输入方法
    public void in(Scanner sc){
        total=sc.nextDouble();
    }

    //电费计算方法
    public double getPrice(){
        if (total<=50.0){
            return price=total*0.56;
        }
        if (total<=220){
            return price=50*0.56+(total-50)*0.59;
        }
        return price=50*0.56+70*0.59+(total-220)*0.66;
    }

    public static void main(String[] args) {
        //创建Scanner对象和Electricity对象
        Scanner sc=new Scanner(System.in);
        Electricity e=new Electricity();

        //循环10次不中断程序
        for (int i=0;i<10;++i){
            e.in(sc);
            System.out.printf("电费为%.2f\n",e.getPrice());
        }

        //关闭Scanner对象
        sc.close();
    }
}
