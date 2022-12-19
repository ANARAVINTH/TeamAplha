package draftcode;

import org.openqa.selenium.InvalidArgumentException;

import java.util.Scanner;

public class ConditionOfJava {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the role");

        String role = scanner.next();


        System.out.println("Enter the number of working days");

        int noOfWorkingDays = scanner.nextInt();

        //Mananger , Staff , clerk
        int salary =0;

        if(noOfWorkingDays >= 1  && noOfWorkingDays <10 ){
        //1,2,3,4,5,6,7,8,9
        }
        else{
            //0,11,10
        }


        if(role.equalsIgnoreCase("Manager")){
           salary=  900 * noOfWorkingDays ;
        }
        else if(role.equalsIgnoreCase("staff")){
             salary=  400 * noOfWorkingDays ;
        }
        else if(role.equalsIgnoreCase("clerk")){
             salary=  200 * noOfWorkingDays ;
        }
        else{  //default block

           throw new InvalidArgumentException("Enter the correct role");
        }

        System.out.println(salary);










    }
}
