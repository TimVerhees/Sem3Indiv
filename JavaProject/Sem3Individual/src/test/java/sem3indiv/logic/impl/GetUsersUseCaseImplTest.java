package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.domain.GetUsersResponse;
import sem3indiv.domain.User;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GetUsersUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @Test
    void getUsers() {

        UserEntity userEntity =
                UserEntity.builder().id(1L).username("user").password("user").type("User").build();
        UserEntity adminEntity =
                UserEntity.builder().id(2L).username("admin").password("admin").type("Admin").build();
        when(userRepositoryMock.findAll())
                .thenReturn(List.of(userEntity, adminEntity));

        User usercard = User.builder().id(1L).username("user").password("user").type("User").build();
        User admincard = User.builder().id(2L).username("admin").password("admin").type("Admin").build();

        GetUsersUseCaseImpl getUsersUseCase = new
                GetUsersUseCaseImpl(userRepositoryMock);
        GetUsersResponse actualResult =
                getUsersUseCase.getUsers();

        GetUsersResponse expectedResult = GetUsersResponse
                .builder()
                .users(List.of(usercard, admincard))
                .build();

        assertEquals(actualResult, expectedResult);
        verify(userRepositoryMock).findAll();
    }
}