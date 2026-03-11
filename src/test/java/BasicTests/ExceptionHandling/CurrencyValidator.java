package BasicTests.ExceptionHandling;

import org.testng.annotations.Test;

public class CurrencyValidator {

    @Test
    public void verifyCurrency(){
        String currency = "";

        try {
            if (currency.equals(null) || currency.isEmpty()) {
                throw new UserDefinedExceptionAnother();
            }else{
                System.out.println(currency + " Currency is specified");
            }
        }catch (UserDefinedExceptionAnother e){
            e.printStackTrace();
        }
    }
}
