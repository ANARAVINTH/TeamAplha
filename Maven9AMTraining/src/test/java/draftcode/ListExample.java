package draftcode;

import java.util.ArrayList;

public class ListExample {

    public static void main(String[] args) {

        ArrayList <Integer> a = new ArrayList<Integer>();

        ArrayList <String> b = new ArrayList<String>();

        a.add(56);
        a.add(100);
        a.add(100);

        System.out.println(a);

        a.add(900);
        System.out.println(a);

        b.add("Aravinth");
        b.add("Learn");

        System.out.println(b);

        for(int i =0 ; i< a.size();i++){
            System.out.println(a.get(i));
        }

        for(int l:a){
            System.out.println(l);
        }

        for(String kk:b){
            System.out.println(kk);
        }

    }
}
