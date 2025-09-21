package experiment1;

import java.util.*;

/*创建一个100×100的二维数组
对数组中的元素进行随机赋值（要求使用Math.random()生成0-1之间的浮点数）
通过算法找到该数组中最大的5个数
要求从大到小输出
同时计算整个程序所耗费的时间*/

/*

public class Matrix extends Thread  {
    private int rows;//行数
    private int cols;//列数
    private float[][] mat;//矩阵数组
    private float[] window;//滑窗数组
    private int biggestNum;//要计算前MostBig大的数

    public Matrix(int rows, int cols, int MostBig){//含参构造函数，传入行数、列数、MostBig
        this.rows=rows;
        this.cols=cols;
        this.biggestNum =MostBig;
        window=new float[MostBig*rows];
        mat=new float[rows][cols];

        Random rand = new Random();
        for (int i = 0; i<rows; ++i)
            for (int j=0;j<cols;++j)
               mat[i][j]=rand.nextFloat();

        for (int i=0;i<rows;++i)
            if (biggestNum >= 0) {
                System.arraycopy(mat[i], 0, window, i * biggestNum, biggestNum);
                sort(i * cols,i+MostBig-1);//对滑窗排序
            }


    }

    private void insert(int index,float n){//插入方法，用于向滑窗数组插入新数
        float[] temp=new float[biggestNum];
        System.arraycopy(window, 0, temp, 0, biggestNum);

        window[index]=n;
        if (biggestNum - (index + 1) >= 0)
            System.arraycopy(temp, index + 1 - 1, window, index + 1, biggestNum - (index + 1));
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

    public void find() throws InterruptedException {//滑窗法寻找前MostBig大的数
        int cores = Runtime.getRuntime().availableProcessors();
        //System.out.println("CPU核心数: " + cores);

        ExecutorService pool = Executors.newFixedThreadPool(5,r -> {
            Thread t = new Thread(r);
            t.setPriority(Thread.MAX_PRIORITY); // 提高优先级
            return t;
        }); // CPU密集型
        for (int k = 0; k < rows; ++k) {
            int finalK = k;
            var ref = new Object() {
                int i = finalK;
            };
            pool.execute(() -> {
                int i = ref.i;
                int p = biggestNum;

                while (p < cols) { // 不断寻找比滑窗内数大的数，找到后插入合适位置
                    for (int j = 0; j < biggestNum; ++j) {
                        if (mat[i][p] >= window[j]) {
                            insert(i * biggestNum + j, mat[i][p]);
                            break;
                        }
                    }
                    ++p;
                }
            });
        }

// 关闭线程池，拒绝新任务
        pool.shutdown();

        try {
            // 等待所有任务执行完，最多等 1 小时
            if (!pool.awaitTermination(1, java.util.concurrent.TimeUnit.HOURS)) {
                System.err.println("任务未在规定时间内完成");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int p=biggestNum;
        float[] win=new float[biggestNum];
        System.arraycopy(window, 0, win, 0, biggestNum);

        float[] temp=new float[biggestNum];
        while(p<cols){//不断寻找比滑窗内数大的数，找到后插入合适位置
            for (int j=0;j<biggestNum;++j){
                if (window[p]>=win[j]){
                    System.arraycopy(win, 0, temp, 0, biggestNum);

                    win[j]=window[p];
                    if (biggestNum - (j + 1) >= 0)
                        System.arraycopy(temp, j, win, j + 1, biggestNum - (j + 1));
                    break;
                }
            }
            ++p;
        }

        window=win;

        //sort(0,window.length-1);
        return;
*/
/*
        Thread[] th=new Thread[rows];
        var ref = new Object() {
            int i = 0;
        };
        ref.i=0;
        for (; ref.i <rows; ++ref.i){
            th[ref.i]=new Thread(() -> {
                int i=ref.i;
                int p=biggestNum;

                while(p<cols){//不断寻找比滑窗内数大的数，找到后插入合适位置
                    for (int j=0;j<biggestNum;++j){
                        if (mat[i][p]>=window[j]){
                            insert(i*biggestNum+j,mat[i][p]);
                            break;
                        }
                    }
                    ++p;
                }
            });

            th[ref.i].start();
        }

        ref.i=0;
        for (; ref.i <rows; ++ref.i)
            th[ref.i].join();

        sort(0,window.length-1);

 */
/*

    }

    public void printResult(){
        for (int i=0;i<biggestNum;++i)
            System.out.print(window[i]+" ");
        System.out.println();
    }

    public void print(){//打印原始矩阵
        for (int i=0;i<rows;++i){
            for (int j=0;j<cols;++j){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        int r=100,c=100,lb=5;
        Matrix mat=new Matrix(r,c,lb);
        System.out.println("原始数组为：");
        mat.print();

        try {
            mat.find();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("前"+mat.biggestNum+"大的数为：");
        mat.printResult();

        long end = System.nanoTime();
        System.out.println("耗时：" + (end - start) / 1_000_000.0 + " 毫秒");
    }
}
*/

public class Matrix {
    //行数
    private int rows;
    //列数
    private int cols;
    //矩阵数组
    private float[] mat;
    //滑窗数组
    private float[] window;
    //前多少最大的数
    private int biggestNum;

    //含参构造函数，传入行数、列数、biggestNum
    public Matrix(int rows, int cols, int biggestNum){
        this.rows=rows;
        this.cols=cols;
        this.biggestNum = biggestNum;
        window=new float[biggestNum];
        mat=new float[rows*cols];

        Random rand = new Random();
        for (int i = 0; i<rows; ++i) {
            for (int j=0;j<cols;++j) {
                setIndex(i,j, rand.nextFloat());
            }
        }

        System.arraycopy(mat, 0, window, 0, biggestNum);
        //对滑窗排序
        sort();
    }

    //插入方法，用于向滑窗数组插入新数
    private void insert(int index,float n){
        float[] temp=new float[biggestNum];
        System.arraycopy(window, 0, temp, 0, biggestNum);

        window[index]=n;
        if (biggestNum - (index + 1) >= 0) {
            System.arraycopy(temp, index + 1 - 1, window, index + 1, biggestNum - (index + 1));
        }
    }

    //快速排序
    private void sort(){
        // 升序
        Arrays.sort(window);

        // 反转数组
        for (int i = 0; i < window.length / 2; i++) {
            float temp = window[i];
            window[i] = window[window.length - 1 - i];
            window[window.length - 1 - i] = temp;
        }
    }

    //滑窗法寻找前biggestNum大的数
    public float[] find(){
        int p= biggestNum;

        //不断寻找比滑窗内数大的数，找到后插入合适位置
        while(p<mat.length){
            for (int i = 0; i< biggestNum; ++i){
                if (mat[p]>=window[i]){
                    insert(i,mat[p]);
                    break;
                }
            }
            ++p;
        }

        printResult();
        return window;
    }

    //矩阵getter方法，可以像二维数组一样访问
    public float atIndex(int i,int j){
        return mat[i*cols+j];
    }

    //矩阵setter方法，可以像二维数组一样设置
    public void setIndex(int i,int j,float n){
        mat[i*cols+j]=n;
    }

    //打印结果
    private void printResult(){
        for (var x: window) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    //打印原始矩阵
    public void print(){
        for (int i=0;i<rows;++i){
            for (int j=0;j<cols;++j){
                System.out.print(atIndex(i,j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        int r=100,c=100,lb=5;
        Matrix mat=new Matrix(r,c,lb);
        System.out.println("原始数组为：");
        mat.print();

        var answer = mat.find();
        System.out.println("前五大的数为：");

        long end = System.nanoTime();
        System.out.println("耗时：" + (end - start) / 1_000_000.0 + " 毫秒");
    }
}

