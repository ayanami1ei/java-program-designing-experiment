package experiment1;

public class Welcome {
    public static void main(String[] args){
        //创建一个有3个元素的字符串数组
        String[] greeting= new String[3];
        //依次为每一个元素赋值
        greeting[0]="Welcome to Core Java";
        greeting[1]="by Cay Horstmann";
        greeting[2]="and Gary Cornell";
        //依次输出每一个元素
        for(String g: greeting)
            System.out.println(g);
    }
}
