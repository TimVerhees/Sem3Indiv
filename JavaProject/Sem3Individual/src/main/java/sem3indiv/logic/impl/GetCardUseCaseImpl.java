package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCardUseCaseImpl implements GetCardUseCase {

    private CardRepository cardRepository;

    @Override
    public Optional<Card> getCard(long cardId) {
        return cardRepository.findById(cardId).map(CardConvertor::convert);
    }
}
