package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.Card;
import Sem3Indiv.logic.GetCardUseCase;
import Sem3Indiv.repository.CardRepository;
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
