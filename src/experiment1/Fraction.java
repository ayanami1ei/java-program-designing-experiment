package experiment1;

/*有一序列（分子为1、2、3、4递增，分母为1、3、9、27倍增）：1/1，2/3，3/9，4/27，5/81，...
求出这个数列的前30项之和*/
import java.math.BigInteger;

public class Fraction {
    //分子分母
    private BigInteger numerator, denominator;

    //默认构造函数，初始化为0
    public Fraction() {
        numerator = BigInteger.ZERO;
        denominator = BigInteger.ONE;
    }

    //含参构造函数
    public Fraction(BigInteger n, BigInteger d) {
        numerator = n;
        denominator = d;
        reduce();
    }

    //化简方法
    private void reduce() {
        BigInteger g = numerator.gcd(denominator);
        numerator = numerator.divide(g);
        denominator = denominator.divide(g);

        // 保证分母为正
        if (denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
    }

    //相加方法
    public Fraction add(Fraction b) {
        return new Fraction(
                numerator.multiply(b.denominator).add(b.numerator.multiply(denominator)),
                denominator.multiply(b.denominator)
        );
    }

    //按x/y的格式打印
    public void print() {
        System.out.println(numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        Flist fl=new Flist(30,3);
        fl.getSum().print();
    }
}


//分数数列类
class Flist{
    //数列数组
    private final Fraction[] flist;
    //分母为k的n次方，n为该数在数列中的索引
    private int k;

    //含参构造函数，传入数列长度和k，初始化数列
    public Flist(int n,int k){
        this.k=k;
        flist=new Fraction[n];

        for (int i = 0; i < n; ++i) {
            BigInteger numerator = BigInteger.valueOf(i + 1);
            BigInteger denominator = BigInteger.valueOf(k).pow(i);
            flist[i] = new Fraction(numerator, denominator);
        }

    }

    //计算总和方法
    public Fraction getSum(){
        Fraction sum=new Fraction();

        for (var x:flist){
            sum=sum.add(x);
        }

        return sum;
    }
}
