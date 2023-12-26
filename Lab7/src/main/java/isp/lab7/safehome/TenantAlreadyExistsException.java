package isp.lab7.safehome;

public class TenantAlreadyExistsException extends Exception{
    public TenantAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
