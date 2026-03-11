package BasicTests.ExceptionHandling;

import org.testng.annotations.Test;

public class ExceptionHandlingNote {


// When a statement throws an exception in the try block, the remaining part of the try block will not be executed
//    Program control comes out of the try block and enters directly into catch block.

    public void remainingStatementOfTryBlockWontExecute(){
        try
        {
            int i = 10/0;           //This statement throws ArithmeticException

            System.out.println("This statement will not be executed");
        }
        catch(Exception ex)
        {
            System.out.println("This block is executed immediately after an exception is thrown");
        }
        finally
        {
            System.out.println("This block is always executed");
        }
    }

//    try, catch and finally blocks form one unit. i.e You can’t keep other statements in between try, catch and finally blocks.
        public void tryCatchAndFinallyBlockIsSingleUnit() {
            System.out.println("You can keep any number of statements here");
            try
            {
                int i = 10/0;           //This statement throws ArithmeticException
                System.out.println("This statement will not be executed");
            }
            //You can't keep statements here
            catch(ArithmeticException ex)
            {
                System.out.println("This block is executed immediately after an exception is thrown");
            }
            //You can't keep statements here
            finally
            {
                System.out.println("This block is always executed");
            }
            System.out.println("You can keep any number of statements here");
        }

//    In some cases, A single statement may throw more than one type of exception.
//    In such cases, Java allows you to put more than one catch blocks.
//    One catch block handles one type of exception.  When an exception is thrown by the try block, all the catch blocks are examined in the order they appear and
//    one catch block which matches with exception thrown will be executed. After, executing catch block, program control comes out of try-catch unit.

    public void multipleCatchBlock() {
        String[] s = {"abc", "123", null, "xyz"};   //String array containing one null object
        for (int i = 0; i < 6; i++)
        {
            try
            {
                int a = s[i].length() + Integer.parseInt(s[i]);
                //This statement may throw NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException
            }
            catch(NumberFormatException ex)
            {
                System.out.println("NumberFormatException will be caught here");
            }
            catch (ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("ArrayIndexOutOfBoundsException will be caught here");
            }
            catch (NullPointerException ex)
            {
                System.out.println("NullPointerException will be caught here");
            }
            System.out.println("After executing respective catch block, this statement will be executed");
        }
    }

    //The above program can be written with pipe operator
    public void multipleExceptionWithPipeOperator(){
        String[] s = {"abc", "123", null, "xyz"};   //String array containing one null object
        for (int i = 0; i < 6; i++)
        {
            try
            {
                int a = s[i].length() + Integer.parseInt(s[i]);
                //This statement may throw NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException
            }
            catch(NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("Now, this block handles NumberFormatException, NullPointerException and ArrayIndexOutOfBoundsException");
            }
        }
    }

//    The order of catch blocks should be from most specific to most general ones. i.e Sub classes of Exception must come first and super classes later.
//    If you keep the super classes first and sub classes later, you will get compile time error : Unreachable Catch Block.
            public void unreachableCatchBlock(){
                try
                {
                    int i = Integer.parseInt("abc");   //This statement throws NumberFormatException
                }
                catch(Exception ex)
                {
                    System.out.println("This block handles all exception types");
                }
//                catch(NumberFormatException ex)
//                {
//                    //Compile time error
//                    //This block becomes unreachable as
//                    //exception is already handled by above catch block
//                }

            }

          

}
