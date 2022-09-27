package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.Card;
import Sem3Indiv.domain.GetAllCardsRequest;
import Sem3Indiv.repository.entity.CardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.domain.GetCardsResponse;
import Sem3Indiv.logic.GetCardsUseCase;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCardsUseCaseImpl implements GetCardsUseCase{
    private final CardRepository cardRepository;



    /*@Override
    public GetCardsResponse getCards() {
        List<Card> cards = cardRepository.findAll()
                .stream()
                .map(CardConvertor::convert)
                .toList();

        return GetCardsResponse.builder()
                .cards(cards)
                .build();
    }*/
    /*@Override
    public Optional<Card> getCard(long cardId) {
        return cardRepository.findById(cardId).map(CardConverter::convert);
    }*/
    @Override
    public GetCardsResponse getCards() {
        List<CardEntity> results;

        results = cardRepository.findAll();


        final GetCardsResponse response = new GetCardsResponse();
        List<Card> cards = results
                .stream()
                .map(CardConvertor::convert)
                .toList();
        response.setCards(cards);

        return response;
    }

}
