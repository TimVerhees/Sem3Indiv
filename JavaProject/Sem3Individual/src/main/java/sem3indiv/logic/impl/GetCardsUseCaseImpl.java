package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.repository.entity.CardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.repository.CardRepository;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.logic.GetCardsUseCase;

import java.util.List;

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
