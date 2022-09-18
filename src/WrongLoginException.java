public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String errorLogin) {
        super(errorLogin);
    }

}
