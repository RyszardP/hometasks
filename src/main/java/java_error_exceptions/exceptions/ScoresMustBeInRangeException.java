package java_error_exceptions.exceptions;

public class ScoresMustBeInRangeException extends Exception {
   public ScoresMustBeInRangeException(){
       super("Score does not in range");
   }

    public ScoresMustBeInRangeException(String s) {
    }

    public ScoresMustBeInRangeException(String message,Throwable cause){
       super(message, cause);
    }
}
