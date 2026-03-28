package br.com.julianomarthins.dscommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
