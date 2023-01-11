package sem3indiv.logic.impl;

import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.logic.DeleteCardUseCase;
import sem3indiv.logic.DeleteUserUseCase;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.UserRepository;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DeleteUserUseCaseImplTest {
    @Mock
    private UserRepository userRepositoryMock;
    @Test
    void deleteUser() {
        UserEntity user1 = UserEntity.builder().id(1L).username("user").password("user").type("User").build();

        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCaseImpl(userRepositoryMock);
        deleteUserUseCase.deleteUser(user1.getId());

        verify((userRepositoryMock), atLeast(1)).deleteById(anyLong());
    }
}