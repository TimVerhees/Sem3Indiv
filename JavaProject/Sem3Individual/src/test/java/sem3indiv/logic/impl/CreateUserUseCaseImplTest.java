package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;
import sem3indiv.domain.CreateUserRequest;
import sem3indiv.domain.CreateUserResponse;
import sem3indiv.domain.GetUsersResponse;
import sem3indiv.domain.User;
import sem3indiv.logic.CreateUserUseCase;
import sem3indiv.logic.GetUsersUseCase;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CreateUserUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private PasswordEncoder passwordEncoderMock;
    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;

    @Test
    void createUser() {
        UserEntity userEntity =
                UserEntity.builder().id(1L).username("user").password("user").type("User").build();
        CreateUserRequest request = CreateUserRequest.builder().username("user").password("user").type("User").build();
        doReturn(userEntity).when(userRepositoryMock).save(any(UserEntity.class));
        CreateUserResponse actualResult = createUserUseCase.createUser(request);
        CreateUserResponse expectedResult = CreateUserResponse.builder().userId(1L).build();

        assertEquals(actualResult.getUserId(), expectedResult.getUserId());
        verify((userRepositoryMock), atLeast(1)).save(any(UserEntity.class));
    }
}