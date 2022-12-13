package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.domain.Card;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.domain.GetUsersResponse;
import sem3indiv.domain.User;
import sem3indiv.logic.GetCardsUseCase;
import sem3indiv.logic.GetUsersUseCase;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

import java.util.List;
@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    public UserRepository userRepository;

    @Override
    public GetUsersResponse getUsers(){
        List<User> users = findAll()
                .stream()
                .map(UserConvertor::convert)
                .toList();
        return GetUsersResponse.builder()
                .users(users)
                .build();
    }

    private List<UserEntity> findAll() {
        // TODO: replace by country repository method call

        return userRepository.findAll();
    }
}
