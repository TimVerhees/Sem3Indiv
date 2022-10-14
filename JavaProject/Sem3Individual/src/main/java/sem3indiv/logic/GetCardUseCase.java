package sem3indiv.logic;

import sem3indiv.domain.Card;

import java.util.Optional;

public interface GetCardUseCase {
    Optional<Card> getCard(long cardId);
}
