package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.logic.DeleteCardUseCase;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;

import static java.lang.Long.TYPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DeleteCardUseCaseImplTest {

    @Mock
    private CardRepository cardRepositoryMock;

    @Test
    void deleteCard() {
        CardEntity card2 = CardEntity.builder().id(1L).name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();

        DeleteCardUseCase deleteCardUseCase = new DeleteCardUseCaseImpl(cardRepositoryMock);
        deleteCardUseCase.deleteCard(card2.getId());

        verify((cardRepositoryMock), atLeast(1)).deleteById(anyLong());

    }
}