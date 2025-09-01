package experiment1;

import java.util.*;

public class Matirx {
    private int row,col;
    private float[] mat;
    private Random rand=new Random();
    private float[] window;
    private int LastBig;

    public Matirx(int row,int col, int lastBig){
        this.row=row;
        this.col=col;
        this.LastBig=lastBig;
        window=new float[LastBig];
        mat=new float[row*col];

        for (int i=0;i<row;++i)
            for (int j=0;j<col;++j)
                setIndex(i,j,rand.nextFloat());

        if (LastBig >= 0) System.arraycopy(mat, 0, window, 0, LastBig);
    }

    private void insert(int index,float n){
        float[] temp=new float[LastBig];
        System.arraycopy(window, 0, temp, 0, LastBig);

        window[index]=n;
        if (LastBig - (index + 1) >= 0) System.arraycopy(temp, index + 1 - 1, window, index + 1, LastBig - (index + 1));
    }

    private void sort(int s,int e){
        if (s>=e || e-s==1)
            return;

        int i=s,j=e;
        float mid=window[(s+e)/2];

        while(i<=j){
            while(window[i]>mid)
                ++i;
            while(window[j]<mid)
                --j;

            if (i<=j){
                float temp=window[i];
                window[i]=window[j];
                window[j]=temp;

                ++i;
                --j;
            }
        }

        sort(s,j);
        sort(i,e);
    }

    public float[] find(){
        System.arraycopy(mat, 0, window, 0, LastBig);

        sort(0,LastBig-1);
        int p=LastBig;

        while(p<mat.length){
            for (int i=0;i<LastBig;++i){
                if (mat[p]>=window[i]){
                    insert(i,mat[p]);
                    break;
                }
            }
            ++p;
        }

        return window;
    }

    public float atIndex(int i,int j){
        return mat[i*col+j];
    }

    public void setIndex(int i,int j,float n){
        mat[i*col+j]=n;
    }

    public void print(float[] arr){
        for (var x: arr)
            System.out.print(x+" ");
        System.out.println();
    }
    public void print(){
        for (var x: mat)
            System.out.print(x+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Matirx mat=new Matirx(10,10,5);
        mat.print();
        var answer = mat.find();
        mat.print(answer);
    }
}
