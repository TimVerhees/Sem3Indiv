package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.UpdateCardRequest;
import Sem3Indiv.logic.UpdateCardUseCase;
import Sem3Indiv.logic.exception.InvalidCardException;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.repository.entity.CardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateCardUseCaseImpl implements UpdateCardUseCase {
    private final CardRepository cardRepository;

    @Override
    public void updateCard(UpdateCardRequest request) {
        Optional<CardEntity> cardOptional = cardRepository.findById(request.getId());
        if (cardOptional.isEmpty()) {
            throw new InvalidCardException("CARD_ID_INVALID");
        }

        CardEntity card = cardOptional.get();
        updateFields(request, card);
    }

    private void updateFields(UpdateCardRequest request, CardEntity card) {
        card.setName(request.getName());

        cardRepository.save(card);
    }

}