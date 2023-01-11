package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;
import sem3indiv.config.ExceptionHandler.InvalidCredentialsException;
import sem3indiv.domain.CreateUserRequest;
import sem3indiv.domain.LoginRequest;
import sem3indiv.logic.AccessTokenEncoder;
import sem3indiv.logic.CreateUserUseCase;
import sem3indiv.logic.LoginUseCase;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.UserEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LoginUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private PasswordEncoder passwordEncoderMock;
    @Mock
    private AccessTokenEncoder accessTokenEncoderMock;

    @Test
    void login_ShouldReturnInvalidCredentialException() {
        UserEntity userEntity =
                UserEntity.builder().id(1L).username("user").password("user").type("User").build();
        CreateUserRequest user_request = CreateUserRequest.builder().username("user").password("user").type("User").build();
        LoginRequest loginRequest = LoginRequest.builder().password("user").username("user").build();
        doReturn(userEntity).when(userRepositoryMock).save(any(UserEntity.class));
        when(userRepositoryMock.findByUsername(anyString())).thenReturn(null);

        CreateUserUseCase createUserUseCase = new CreateUserUseCaseImpl(userRepositoryMock, passwordEncoderMock);
        createUserUseCase.createUser(user_request);
        LoginUseCase loginUseCase = new LoginUseCaseImpl(userRepositoryMock, passwordEncoderMock, accessTokenEncoderMock);
        assertThrows(InvalidCredentialsException.class, () -> loginUseCase.login(loginRequest));

        verify((userRepositoryMock), atLeast(1)).findByUsername(anyString());
        verify((passwordEncoderMock), atLeast(1)).encode(anyString());
    }
}