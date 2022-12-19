package draftcode;

public class ThisExample extends  StringExample {

     int a =1;
     static  String b = "LearnMore";
    public static void main(String[] args) {

        ThisExample thisExample = new ThisExample() ;
        m2();
        thisExample.m1();

        System.out.println(b);
    }

    public void m1(){
        int a = 2;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(b);
        System.out.println(super.a);
    }

    public static void m2(){
        System.out.println("static");
    }
}
