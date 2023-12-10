package crengine.util.exception;

/**引擎报错使用的*/
public class CrengineRuntimeException extends RuntimeException {
    public CrengineRuntimeException(String message) {
        super(message);
    }

    public CrengineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrengineRuntimeException(Throwable cause){
        super(cause);
    }
}
