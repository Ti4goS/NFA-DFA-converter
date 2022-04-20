package controller;

public class StatesException extends RuntimeException{
    private static final long serialVersionUID = 4928599035264976611L;

    public StatesException(String message) {
        super(message);
    }

    public StatesException(Throwable cause) {
        super(cause);
    }

}
