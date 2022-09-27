package Sem3Indiv.logic;

import Sem3Indiv.domain.CreateCardRequest;
import Sem3Indiv.domain.CreateCardResponse;
public interface CreateCardUseCase {
    CreateCardResponse createCard(CreateCardRequest request);
}
