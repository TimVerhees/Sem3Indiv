package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.domain.GetCardsResponse;
import Sem3Indiv.logic.GetCardsUseCase;

import java.util.List;
@Service
@AllArgsConstructor
public class GetCardsUseCaseImpl implements GetCardsUseCase{
    private final CardRepository cardRepository;



    @Override
    public GetCardsResponse getCards() {
        List<Card> cards = cardRepository.findAll()
                .stream()
                .map(CardConvertor::convert)
                .toList();

        return GetCardsResponse.builder()
                .cards(cards)
                .build();
    }
}
