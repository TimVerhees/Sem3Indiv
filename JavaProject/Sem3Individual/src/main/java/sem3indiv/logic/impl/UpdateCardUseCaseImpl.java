package sem3indiv.logic.impl;

import sem3indiv.domain.UpdateCardRequest;
import sem3indiv.logic.UpdateCardUseCase;
import sem3indiv.logic.exception.InvalidCardException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;
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
        card.setDesc(request.getDesc());

        cardRepository.save(card);
    }

}
