package sem3indiv.logic;

import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.CreateCardResponse;
public interface CreateCardUseCase {
    CreateCardResponse createCard(CreateCardRequest request);
}
