package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.CreateCardRequest;
import Sem3Indiv.domain.CreateCardResponse;
import Sem3Indiv.logic.CardIdValidator;
import Sem3Indiv.logic.CreateCardUseCase;
import Sem3Indiv.logic.exception.NameAlreadyExistsException;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.repository.entity.CardEntity;
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
