package sem3indiv.logic;

import sem3indiv.logic.exception.InvalidCardException;

public interface CardIdValidator {
    void validateId(Long cardId) throws InvalidCardException;
}
