package BasicTests.ExceptionHandling;

public class UserDefinedExceptionAnother extends Exception{

    @Override
   public String toString(){
        return "Please specify valid currency";
    }

}
