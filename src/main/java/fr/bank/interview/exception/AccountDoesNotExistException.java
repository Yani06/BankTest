package fr.bank.interview.exception;

public class AccountDoesNotExistException extends Exception {

	private static final long serialVersionUID = -8071122815276901061L;

	public AccountDoesNotExistException(){
        // empty constructor
    }

    public AccountDoesNotExistException(String msg){
        super(msg);
    }

    public AccountDoesNotExistException(Exception e){
        super(e);
    }
}