package sem3indiv.logic;

import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.CreateCardResponse;
import sem3indiv.domain.CreateUserRequest;
import sem3indiv.domain.CreateUserResponse;

public interface CreateUserUseCase {

    CreateUserResponse createUser(CreateUserRequest request);
}
