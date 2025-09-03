package experiment1;

import java.util.Arrays;
import java.util.Scanner;

public class Prime {
    int n;
    int[] elist;
    Scanner sc=new Scanner(System.in);

    public Prime(){
        n=sc.nextInt();
        elist=new int[n+1];

        Arrays.fill(elist,1);

        elist[0]=0;
        elist[1]=0;

        for (int i=2;i<=n;++i){
            if (elist[i]==1){
                for (int j=i*2;j<=n;j+=i){
                    elist[j]=0;
                }
            }
        }
    }

    public void PrintAll(){
        for (int i=0;i<=n;++i){
            if (elist[i]==1){
                System.out.print(i+" ");
            }
        }
    }

    public void close(){
        sc.close();
    }

    public static void main(String[] args) {
        Prime p=new Prime();
        p.PrintAll();
        p.close();
    }
}
