package draftcode;

public class StringExample {

   protected int a = 25;

    public static void mainn() {


        String name = "Learn"; // 0 1 2 3 4

        System.out.println(name.length());

        String b = "                More h             ";

        System.out.println(name.concat(b));

        System.out.println(b.trim());

        System.out.println(name.charAt(1));

        String u = "abc";

        String j = "ABC";

        System.out.println(u.equalsIgnoreCase(j));

        String k = "The amount is $ 20 ";

        System.out.println(k.contains("ah"));

        System.out.println(u.toUpperCase());

        System.out.println(j.toLowerCase());

        String bb = "how are you";

      String userName = bb.substring(4,7);

      String dd = "123.23454";

      int a = 5;

     Float bbb = Float.parseFloat(dd);

        System.out.println(a + bbb);

        System.out.println(bb.replace('h','o')  ) ;

    }

}
