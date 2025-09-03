package experiment1;

import java.util.Scanner;

public class Flist{
    Fraction[] flist;
    Scanner sc=new Scanner(System.in);
    int k;

    public Flist(int n,int k){
        sc.close();
        this.k=k;
        flist=new Fraction[n];

        for (int i=0;i<n;++i){
            flist[i]=new Fraction(i+1, (int)Math.pow(k,i));
        }
    }

    public Fraction getSum(){
        Fraction sum=new Fraction();

        for (var x:flist){
            sum=sum.add(x);
        }

        return sum;
    }

    public static void main(String[] args) {
        Flist fl=new Flist(30,3);
        fl.getSum().print();
    }
}

class Fraction {
    private int numerator,denominator;
    public Fraction(){
        numerator=0;
        denominator=1;
    }
    public Fraction(int n,int d){
        numerator=n;
        denominator=d;

        gcd();
    }

    private void gcd(){
        int a=numerator,b=denominator;
        if (a<b){
            int temp=a;
            a=b;
            b=temp;
        }

        int t = 1;
        while(t != 0) {
            t = a % b;
            a = b;
            b = t;
        }

        numerator/=a;
        denominator/=a;
    }

    public void set(int n,int d){
        numerator=n;
        denominator=d;
    }

    public Fraction add(Fraction b){
        Fraction result = new Fraction((numerator * b.denominator) + (b.numerator * denominator),denominator*b.denominator);
        result.gcd();
        return result;
    }

    public void print(){
        System.out.println(numerator+"/"+denominator);
    }
}

