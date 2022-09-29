package Sem3Indiv.logic.impl;

import Sem3Indiv.logic.DeleteCardUseCase;
import Sem3Indiv.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCardUseCaseImpl implements DeleteCardUseCase {
    private final CardRepository cardRepository;

    @Override
    public void deleteCard(long cardId) {
        this.cardRepository.deleteById(cardId);
    }
}
