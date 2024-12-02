package org.example.rh.demo.Erreurs;

public class ErreurSythaxiqueException extends Exception{


    public ErreurSythaxiqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErreurSythaxiqueException(Throwable cause) {
        super(cause);
    }

}
