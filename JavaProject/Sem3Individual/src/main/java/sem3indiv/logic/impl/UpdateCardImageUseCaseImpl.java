package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.domain.UpdateCardImageRequest;
import sem3indiv.domain.UpdateCardRequest;
import sem3indiv.logic.UpdateCardImageUseCase;
import sem3indiv.logic.exception.InvalidCardException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateCardImageUseCaseImpl implements UpdateCardImageUseCase {

    private final CardRepository cardRepository;
    @Override
    public void updateCardImage(UpdateCardImageRequest request){

        Optional<CardEntity> cardOptional = cardRepository.findById(request.getId());

        if (cardOptional.isEmpty()) {
            throw new InvalidCardException("CARD_ID_INVALID");
        }
        CardEntity card = cardOptional.get();
        updateFields(request, card);
    }


    public void updateFields(UpdateCardImageRequest request, CardEntity card){
        card.setCard_image(request.getCard_image());

        cardRepository.save(card);
    }
}
