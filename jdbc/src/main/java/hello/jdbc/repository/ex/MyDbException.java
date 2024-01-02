package hello.jdbc.repository.ex;

public class MyDbException extends RuntimeException { //runtimeexception을 extends했으므로 unchecked 예외
    public MyDbException() {
    }

    public MyDbException(String message) {
        super(message);
    }

    public MyDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDbException(Throwable cause) {
        super(cause);
    }
}
