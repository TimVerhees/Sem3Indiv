package sem3indiv.logic.impl;

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
    private final CardRepository cardRepository;

    @Override
    public CreateCardResponse createCard(CreateCardRequest request) {
        if (cardRepository.existsByName(request.getName())) {
            throw new NameAlreadyExistsException();
        }

        CardEntity savedCard = saveNewCard(request);

        return CreateCardResponse.builder()
                .cardId(savedCard.getId())
                .build();
    }

    private CardEntity saveNewCard(CreateCardRequest request) {

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
        return cardRepository.save(newCard);
    }
}
