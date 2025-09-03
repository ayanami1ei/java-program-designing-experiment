package experiment1;

import java.util.Scanner;

public class eletricity {
    private Scanner sc=new Scanner(System.in);
    private double total,price;

    public void close(){
        sc.close();
    }

    public void in(){
        total=sc.nextDouble();
    }

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
        eletricity e=new eletricity();

        for (int i=0;i<10;++i){
            e.in();
            System.out.println("电费为"+e.getPrice());
        }

        e.close();
    }
}
