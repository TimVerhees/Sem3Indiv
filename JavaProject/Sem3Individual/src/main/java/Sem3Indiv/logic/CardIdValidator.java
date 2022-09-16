package Sem3Indiv.logic;

import Sem3Indiv.logic.exception.InvalidCardException;

public interface CardIdValidator {
    void validateId(Long cardId) throws InvalidCardException;
}
