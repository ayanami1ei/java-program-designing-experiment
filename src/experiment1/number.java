package experiment1;

import java.util.Scanner;

public class number {
    private int n;
    private StringBuilder sb;
    Scanner sc=new Scanner(System.in);

    public void in(){
        n=sc.nextInt();
        sb=new StringBuilder(String.valueOf(n));
    }

    public void reverse(){
        sb.reverse();
        System.out.println(sb.toString());
    }

    public void out(){
        System.out.println(n);
    }

    public void close(){
        sc.close();
    }

    public static void main(String[] args) {
        number n=new number();
        for (int i=0;i<10;i++){
            n.in();
            n.out();
            n.reverse();
        }
        n.close();
    }
}
