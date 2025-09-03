package experiment1;

import java.util.Scanner;

public class Teacher {
    private String name, title,course,research,office;

    public void in(Scanner sc){
        name=sc.next();
        title=sc.next();
        course=sc.next();
        research=sc.next();
        office=sc.next();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public static void main(String[] args) {
        Teacher t=new Teacher();
        t.setName("aaa");
        System.out.println("name:"+t.getName());

        t.setTitle("bbb");
        System.out.println("title:"+t.getTitle());

        t.setCourse("ccc");
        System.out.println("course:"+t.getCourse());

        t.setResearch("ddd");
        System.out.println("research:"+t.getResearch());

        t.setOffice("eee");
        System.out.println("office:"+t.getOffice());
    }
}
