package Sem3Indiv.logic;

import Sem3Indiv.domain.Card;

import java.util.Optional;

public interface GetCardUseCase {
    Optional<Card> getCard(long cardId);
}
