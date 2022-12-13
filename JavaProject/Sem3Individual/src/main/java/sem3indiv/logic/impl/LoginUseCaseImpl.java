package sem3indiv.logic.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.config.ExceptionHandler.InvalidCredentialsException;
import sem3indiv.domain.AccessToken;
import sem3indiv.domain.LoginRequest;
import sem3indiv.domain.LoginResponse;
import sem3indiv.logic.AccessTokenEncoder;
import sem3indiv.logic.LoginUseCase;
import sem3indiv.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import sem3indiv.repository.entity.UserEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {

        return passwordEncoder.matches(rawPassword, encodedPassword);


    }

    private String generateAccessToken(UserEntity user) {
        String role = user.getType();
        Long userid = user.getId();

        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(user.getUsername())
                        .role(role)
                        .userId(userid)
                        .build());
    }
}
