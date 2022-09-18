public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String errorPassword) {
        super(errorPassword);
    }

}
