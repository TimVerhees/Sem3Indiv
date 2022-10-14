package sem3indiv.logic.impl;

import sem3indiv.logic.DeleteCardUseCase;
import sem3indiv.repository.CardRepository;
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
