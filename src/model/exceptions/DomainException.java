package model.exceptions;

public class DomainException extends Exception{ //RuntimeException (Tipo de exceção que o computador não obriga a tratar) Exception (obriga a tratar)
    public DomainException(String msg){
        super(msg);
    }
}
