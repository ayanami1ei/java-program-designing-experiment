package experiment2;

public class Test {
    public void test1() {
        // 判断字符串 "Hi, ABC, good" 是否完全匹配正则表达式 "ABC "
        System.out.println("Hi, ABC, good".matches("ABC "));

        // 判断字符串 "Hi, ABC, good" 是否匹配正则表达式 ".*ABC.*"
        System.out.println("Hi, ABC, good".matches(".*ABC.*"));

        // 将字符串 "A,B;c" 中所有匹配 ",;" 的部分替换为 "#"
        System.out.println("A,B;c".replaceAll(",;", "#"));

        // 将字符串 "A,B;c" 中所有的 ',' 或 ';' 替换为 '#'
        System.out.println("A,B;c".replaceAll("[,;]", "#"));

        // 按照正则 "[,;]"（即以 ',' 或 ';' 分隔）拆分字符串 "A,B;c"
        String[] tokens = "A,B;c".split("[,;]");

        // 遍历 tokens 数组并输出每个元素，用空格分隔
        for (String token : tokens) {
            System.out.print(token + " ");
        }
    }


    public void test2() {
        // 定义一个字符串变量 s
        String s = "Hi, Good Morning";

        // 调用 m() 方法统计字符串中大写字母的个数，并输出结果
        System.out.println(m(s));
    }

    // 定义一个静态方法 m，用于统计字符串中大写字母的数量
    public static int m(String s) {
        // 用于记录大写字母的数量
        int count = 0;

        // 遍历字符串的每一个字符
        for (int i = 0; i < s.length(); i++) {
            // 判断当前字符是否为大写字母
            if (Character.isUpperCase(s.charAt(i))) {
                // 如果是大写字母，计数加一
                count++;
            }
        }

        // 返回统计的结果
        return count;
    }

    public void test3() {
        // 创建一个字符串 s，值为 "Java"
        String s = "Java";

        // 创建一个 StringBuilder 对象，并用 s 初始化
        StringBuilder builder = new StringBuilder(s);

        // 调用 change 方法
        change(s, builder);

        // 打印字符串 s
        System.out.println(s);

        // 打印 StringBuilder 对象的内容
        System.out.println(builder);
    }

    // 定义一个私有静态方法 change，尝试修改字符串和 StringBuilder
    private static void change(String s, StringBuilder builder) {
        // 字符串是不可变对象，这里的修改只作用于局部变量 s，不会影响原始字符串
        s = s + " and HTML";

        // StringBuilder 是可变对象，append 会真正改变对象内容
        builder.append(" and HTML");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test3();
    }
}