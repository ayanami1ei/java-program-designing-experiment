package experiment1;

/*有一序列（分子为1、2、3、4递增，分母为1、3、9、27倍增）：1/1，2/3，3/9，4/27，5/81，...
求出这个数列的前30项之和*/

@SuppressWarnings("ClassEscapesDefinedScope")
public class Flist{//分数数列类
    private final Fraction[] flist;
    private int k;//分母为k的n次方，n为该数在数列中的索引

    public Flist(int n,int k){//含参构造函数，传入数列长度和k，初始化数列
        this.k=k;
        flist=new Fraction[n];

        for (int i=0;i<n;++i){
            flist[i]=new Fraction(i+1, (int)Math.pow(k,i));
        }
    }

    public Fraction getSum(){//计算总和方法
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

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}

class Fraction {//分数类
    private int numerator,denominator;
    public Fraction(){//默认构造函数，初始化为符合分数写法的0
        numerator=0;
        denominator=1;
    }
    public Fraction(int n,int d){//含参构造函数，自动化简
        numerator=n;
        denominator=d;

        gcd();
    }

    private void gcd(){//分数化简方法，计算最大公约数
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

    public Fraction add(Fraction b){//分数相加方法，相加后自动化简结果
        Fraction result = new Fraction((numerator * b.denominator) + (b.numerator * denominator),denominator*b.denominator);
        result.gcd();
        return result;
    }

    public void print(){
        System.out.println(numerator+"/"+denominator);
    }
}

