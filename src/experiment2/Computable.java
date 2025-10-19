package experiment2;

public interface Computable {
    Computable add(Computable other) throws Exception;              // 向量加法

    Computable minus(Computable other) throws Exception;            // 向量减法

    Computable elementwiseProduct(Computable other) throws Exception; // 逐元素乘积

    String toString();
}


class Vector implements Computable {
    private int len;
    private int[] nums;

    public Vector() {
        len = 0;
        nums = null;
    }

    public Vector(int len) {
        this.len = len;
        nums = new int[this.len];
    }

    public Vector(int[] arr) {
        len = arr.length;
        nums = new int[len];
        for (int i = 0; i < len; ++i) {
            nums[i] = arr[i];
        }
    }

    public int atIndex(int index) throws Exception {
        if (index >= len || index < 0) {
            throw new Exception("illegal index");
        }
        return nums[index];
    }

    public void setIndex(int index, int val) throws Exception {
        if (index >= len || index < 0) {
            throw new Exception("illegal index");
        }

        nums[index] = val;
    }

    @Override
    public Computable add(Computable other) throws Exception {
        Vector vec = (Vector) other;

        if (len != vec.len) {
            throw new Exception("size mismatch");
        }

        Vector res = new Vector(len);

        for (int i = 0; i < len; i++) {
            res.nums[i] = this.nums[i] + vec.nums[i];
        }

        return res;
    }

    @Override
    public Computable minus(Computable other) throws Exception {
        Vector vec = (Vector) other;

        if (len != vec.len) {
            throw new Exception("size mismatch");
        }

        Vector res = new Vector(len);
        for (int i = 0; i < len; ++i) {
            res.nums[i] = this.nums[i] - vec.nums[i];
        }

        return res;
    }

    @Override
    public Computable elementwiseProduct(Computable other) throws Exception {
        Vector vec = (Vector) other;

        if (len != vec.len) {
            throw new Exception("size mismatch");
        }

        Vector res = new Vector(len);
        for (int i = 0; i < len; ++i) {
            res.nums[i] = this.nums[i] * vec.nums[i];
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("(");
        for (int i = 0; i < len; ++i) {
            res.append(String.valueOf(nums[i]));
            if (i != len - 1) {
                res.append(",");
            }
        }
        res.append(")");
        return res.toString();
    }
}

class ComputableExample {
    public static void main(String[] args) {
        Computable v1, v2;
        v1 = new Vector(new int[]{5, 2, 1, 8});
        v2 = new Vector(new int[]{3, -1, 0, -4});

        try {
            System.out.println("v1=" + v1);
            System.out.println("v2=" + v2);
            System.out.println("v1+v2=" + v1.add(v2));
            System.out.println("v1-v2=" + v1.minus(v2));
            System.out.println("v1*v2=" + v1.elementwiseProduct(v2));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
