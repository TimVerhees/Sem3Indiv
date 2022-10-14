package sem3indiv.logic.impl;

import sem3indiv.logic.*;
import sem3indiv.logic.exception.InvalidCardException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.repository.*;

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
