package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.CreateCardResponse;
import sem3indiv.domain.CreateUserRequest;
import sem3indiv.domain.CreateUserResponse;
import sem3indiv.logic.CreateCardUseCase;
import sem3indiv.logic.CreateUserUseCase;
import sem3indiv.logic.exception.NameAlreadyExistsException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {


        UserEntity savedUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .userId(savedUser.getId())
                .build();
    }

    private UserEntity saveNewUser(CreateUserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserEntity newUser = UserEntity.builder()
                .username(request.getUsername())
                .password(encodedPassword)
                .type(request.getType())
                .build();


        return userRepository.save((newUser));
    }
}
