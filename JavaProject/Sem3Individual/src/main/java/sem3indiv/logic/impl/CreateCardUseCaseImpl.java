package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.CreateCardResponse;
import sem3indiv.logic.CreateCardUseCase;
import sem3indiv.logic.exception.NameAlreadyExistsException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCardUseCaseImpl implements CreateCardUseCase {
    private CardRepository cardRepository;

    @Override
    public CreateCardResponse createCard(CreateCardRequest request) {

        if (existsByName(request.getName())) {
            throw new NameAlreadyExistsException();
        }

        CardEntity newCard = CardEntity.builder()
                .name(request.getName())
                .type(request.getType())
                .desc(request.getDesc())
                .atk(request.getAtk())
                .def(request.getDef())
                .level(request.getLevel())
                .race(request.getRace())
                .attribute(request.getAttribute())
                .link(request.getLink())
                .ogbanlist(request.getOgbanlist())
                .build();

        CardEntity savedCard = saveNewCard(newCard);

        return CreateCardResponse.builder()
                .cardId(savedCard.getId())
                .build();
    }

    private CardEntity saveNewCard(CardEntity card) {

        cardRepository.save((card));
        return CardEntity.builder().build();
    }

    private boolean existsByName(String cardName) {
        // TODO: replace by countryRepository correct method call and return
        return (cardRepository.existsByName(cardName));

    }
}
