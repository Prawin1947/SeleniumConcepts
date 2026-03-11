package BasicTests.ExceptionHandling;

import org.testng.annotations.Test;

public class ExamplesOfException {

    @Test
    public void numberFormatException(){
        try{
            //The below code will throw the number format exception
            Integer integer = new Integer("java");
        }catch (NumberFormatException n){
            n.printStackTrace();
        }
        System.out.println("This will executed");

    }

    @Test
    public void arithmaticException (){
        try{
            //The below code will throw the arithmatic Exception
           int i = 100/0;
        }catch (ArithmeticException n){
            n.printStackTrace();
        }
        System.out.println("This will executed");

    }

    @Test
    public void arrayIndexOutOfBoundsException (){
        try{
            String[] arr = new String[]{"Zero","One"};
            String s = arr[2];
            System.out.println("This will throw array index");

        }catch (ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
        }
        System.out.println("This will executed");

    }

    @Test
    public void classCastException(){
        System.out.println("This statement will be executed");

        Object o = new Object();
        try
        {
            ExamplesOfException e = (ExamplesOfException) o;   //This statement throws ClassCastException
        }
        catch (ClassCastException e)
        {
            System.out.println("Exception Caught");
        }
        System.out.println("This will executed");

    }

    @Test
    public void nullPointerException(){
        String s = null;
        try
        {
            System.out.println(s.length());
        }
        catch (ClassCastException e)
        {
            System.out.println("Exception Caught");
        }
        System.out.println("This will executed");

    }
}
