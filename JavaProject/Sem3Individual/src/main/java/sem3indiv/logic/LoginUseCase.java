package sem3indiv.logic;

import sem3indiv.domain.LoginRequest;
import sem3indiv.domain.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}
