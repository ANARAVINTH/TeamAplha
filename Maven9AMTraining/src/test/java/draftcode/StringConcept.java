package draftcode;

import org.openqa.selenium.InvalidArgumentException;

import java.util.Scanner;

public class StringConcept {

    public void sam(){

        StringExample s = new StringExample();

    }
    public static void main(String[] args) {


        String a ="1";

        String b = "2";

        System.out.println(a + b);

        int u = 2;
        int y = 9;
        System.out.println( u + y);

        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int result = 0;

        switch ((firstNumber >= 1 && firstNumber <=5) ? 0 :
                (firstNumber>=6 && firstNumber <= 10) ? 1 : 2){

            case 0:
                result = firstNumber + 1;
                break;

            case 1:
                result = firstNumber + 2;
                break;
            case 2:
               result = firstNumber + 100;
               break;

        }

        System.out.println(result);





    }
}
