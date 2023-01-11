package sem3indiv.logic.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class InvalidCardException extends ResponseStatusException {
    public InvalidCardException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
