package BasicTests.ExceptionHandling;

import org.testng.annotations.Test;

public class AgeValidator {


    @Test
    public void validator(){
        int age = 15;

        try{
            if(age>18 && age<100){
                System.out.println("Valid Age");
            }else{
               throw new UserDefinedException(age +" is not a valid age for Army");
            }
        }catch (UserDefinedException exception){
            exception.printStackTrace();
        }


    }
}
