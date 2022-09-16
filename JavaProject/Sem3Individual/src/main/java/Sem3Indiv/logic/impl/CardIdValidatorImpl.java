package Sem3Indiv.logic.impl;

import Sem3Indiv.logic.*;
import Sem3Indiv.logic.exception.InvalidCardException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Sem3Indiv.repository.*;

@Service
@AllArgsConstructor
public class CardIdValidatorImpl implements CardIdValidator {
    private final CardRepository cardRepository;

    @Override
    public void validateId(Long cardId) {
        if (cardId == null || !cardRepository.existsById(cardId)) {
            throw new InvalidCardException();
        }
    }
}
