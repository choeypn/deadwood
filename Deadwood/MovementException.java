package Deadwood;

public class MovementException extends Exception {

    public MovementException(){
        super("Invalid player movement");
    }
}
