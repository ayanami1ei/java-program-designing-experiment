package experiment1;

import java.util.Arrays;
import java.util.Scanner;

/*计算1-600之间有多少个素数
并输出所有素数*/

public class Prime {
    int n;
    int[] enlist;//埃氏表

    public Prime(Scanner sc){//从键盘读取上限并构建埃氏表
        n=sc.nextInt();
        enlist =new int[n+1];

        Arrays.fill(enlist,1);//初始化数组全为1

        enlist[0]=0;
        enlist[1]=0;//0、1不是素数

        for (int i=2;i<=n;++i){
            if (enlist[i]==1){//若该数是素数，则其倍数不是素数
                for (int j=i*2;j<=n;j+=i){
                    enlist[j]=0;
                }
            }
        }
    }

    public void PrintAll(){//输出素数
        for (int i=0;i<=n;++i){
            if (enlist[i]==1){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Prime p=new Prime(sc);
        p.PrintAll();
        sc.close();
    }
}
