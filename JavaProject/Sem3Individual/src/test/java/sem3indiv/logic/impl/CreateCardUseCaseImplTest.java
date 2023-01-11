package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sem3indiv.domain.CreateBanlistResponse;
import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.CreateCardResponse;
import sem3indiv.logic.exception.NameAlreadyExistsException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CreateCardUseCaseImplTest {

    @Mock
    private CardRepository cardRepositoryMock;

    @InjectMocks
    private CreateCardUseCaseImpl createCardUseCase;


    @Test
    void createCard() {
        CardEntity card1 = CardEntity.builder().id(1L).name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        CreateCardRequest request = CreateCardRequest.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        doReturn(card1).when(cardRepositoryMock).save(any(CardEntity.class));

        CreateCardResponse actualResult = createCardUseCase.createCard(request);
        CreateCardResponse expectedResult = CreateCardResponse.builder().cardId(1L).build();

        //assertEquals(expectedResult.getCardId(), actualResult.getCardId());
        verify((cardRepositoryMock), atLeast(1)).save(any(CardEntity.class));
    }
    @Test
    void createCard_ShouldReturnCardAlreadyExists() {
        CreateCardRequest request1 = CreateCardRequest.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();

        when(cardRepositoryMock.existsByName(request1.getName())).thenReturn(true);

        //createCardUseCase.createCard(request1);
        assertThrows(NameAlreadyExistsException.class, () -> createCardUseCase.createCard(request1));
        verify((cardRepositoryMock), atLeast(1)).existsByName(request1.getName());
    }
}