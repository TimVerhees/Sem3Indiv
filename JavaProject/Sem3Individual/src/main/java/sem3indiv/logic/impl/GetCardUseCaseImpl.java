package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.repository.entity.CardEntity;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCardUseCaseImpl implements GetCardUseCase {

    private CardRepository cardRepository;

    @Override
    public Optional<Card> getCard(long cardId) {
        return cardRepository.findById(cardId).map(CardConvertor::convert);
    }

    @Override
    public String getCardName(String cardName) {

        Optional<CardEntity> tempCard = cardRepository.findByName(cardName);
        if (tempCard.isEmpty()) {
            return null;
        }

        Card card = CardConvertor.convert(tempCard.get());
        String name = card.getName();
        return name;
    }
}
