package BasicTests.ExceptionHandling;

public class UserDefinedException extends Exception{

    String exception = null;

    public UserDefinedException(String exceptionMessage){
        exception  = exceptionMessage;
    }

    @Override
    public String toString() {
        return exception;
    }
}
