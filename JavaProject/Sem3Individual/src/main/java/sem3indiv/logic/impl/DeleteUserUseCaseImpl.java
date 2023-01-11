package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.logic.DeleteUserUseCase;
import sem3indiv.repository.UserRepository;
@Service
@AllArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepository userRepository;

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
