package experiment1;

import java.util.Arrays;
import java.util.Scanner;

/*计算1-600之间有多少个素数
并输出所有素数*/

public class Prime {
    //埃氏表大小上限
    private int n;
    //埃氏表
    private int[] eraList;

    //从键盘读取上限并构建埃氏表
    public Prime(Scanner sc){
        n=sc.nextInt();
        eraList =new int[n+1];

        //初始化数组全为1
        Arrays.fill(eraList,1);

        //0、1不是素数
        eraList[0]=0;
        eraList[1]=0;

        for (int i=2;i<=n;++i){
            //若该数是素数，则其倍数不是素数
            if (eraList[i]==1){
                for (int j=i*2;j<=n;j+=i){
                    eraList[j]=0;
                }
            }
        }
    }

    //输出素数
    public void printAll(){
        for (int i=0;i<=n;++i){
            if (eraList[i]==1){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Prime p=new Prime(sc);
        p.printAll();
        sc.close();
    }
}
