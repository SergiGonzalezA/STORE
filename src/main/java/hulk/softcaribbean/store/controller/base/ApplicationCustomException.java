package hulk.softcaribbean.store.controller.base;

import hulk.softcaribbean.store.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationCustomException extends Exception {

    private final Logger log = LoggerFactory.getLogger(ApplicationCustomException.class);


    private static final long serialVersionUID = 2962065458808354006L;
    private final int code;
    private final String message;

    public ApplicationCustomException(int code, String message, Throwable e) {
        super(message,e);
        this.code = code;
        this.message = message;
    }

    public ApplicationCustomException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ResponseMessage<Object> getResponse(){
        return new ResponseMessage<Object>(this.code, this.message, null);
    }

    public int getCode(){
        return this.code;
    }

}
