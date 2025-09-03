package experiment1;

import java.util.*;

/*创建一个100×100的二维数组
对数组中的元素进行随机赋值（要求使用Math.random()生成0-1之间的浮点数）
通过算法找到该数组中最大的5个数
要求从大到小输出
同时计算整个程序所耗费的时间*/

public class Matrix {
    private int row;//行数
    private final int col;//列数
    private final float[] mat;//矩阵数组
    private final float[] window;//滑窗数组
    private final int LastBig;//要计算前LastBig大的数

    public Matrix(int row, int col, int lastBig){//含参构造函数，传入行数、列数、LastBig
        this.row=row;
        this.col=col;
        this.LastBig=lastBig;
        window=new float[LastBig];
        mat=new float[row*col];

        Random rand = new Random();
        for (int i = 0; i<row; ++i)
            for (int j=0;j<col;++j)
                setIndex(i,j, rand.nextFloat());

        System.arraycopy(mat, 0, window, 0, LastBig);
    }

    private void insert(int index,float n){//插入方法，用于向滑窗数组插入新数
        float[] temp=new float[LastBig];
        System.arraycopy(window, 0, temp, 0, LastBig);

        window[index]=n;
        if (LastBig - (index + 1) >= 0)
            System.arraycopy(temp, index + 1 - 1, window, index + 1, LastBig - (index + 1));
    }

    private void sort(int s,int e){//快速排序
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

    public float[] find(){//滑窗法寻找前LastBig大的数
        System.arraycopy(mat, 0, window, 0, LastBig);//滑窗初始化为矩阵前LastBig位

        sort(0,LastBig-1);//先对滑窗排序
        int p=LastBig;

        while(p<mat.length){//不断寻找比滑窗内数大的数，找到后插入合适位置
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

    public float atIndex(int i,int j){//矩阵getter方法，可以像二维数组一样访问
        return mat[i*col+j];
    }

    public void setIndex(int i,int j,float n){//矩阵setter方法，可以像二维数组一样设置
        mat[i*col+j]=n;
    }

    public void printResult(){
        for (var x: window)
            System.out.print(x+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int r=10,c=10,lb=5;
        Matrix mat=new Matrix(r,c,lb);

        for (int i=0;i<r;++i){//打印原始矩阵
            for (int j=0;j<c;++j){
                System.out.print(mat.atIndex(i,j)+" ");
            }
            System.out.println();
        }
        System.out.println();

        var answer = mat.find();
        System.out.println("前五大的数为：");
        mat.printResult();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
