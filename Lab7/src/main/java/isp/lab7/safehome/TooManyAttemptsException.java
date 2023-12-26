package isp.lab7.safehome;

public class TooManyAttemptsException extends Exception{
    public TooManyAttemptsException(String errorMessage){
        super(errorMessage);
    }
}
