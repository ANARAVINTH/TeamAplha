package draftcode;

public class OverLoadingExample {

    public static void main(String[] args) {

        OverLoadingExample e = new OverLoadingExample();
        e.m1(7,9);

    }

    public void m1(int a){
        System.out.println(a);
    }

    public void m1(String a){
        System.out.println(a);
    }

    public void m1(int a , int b){
        System.out.println(a + b);
    }

    public void m1(String a , int b){
        System.out.println(a);
    }

}
