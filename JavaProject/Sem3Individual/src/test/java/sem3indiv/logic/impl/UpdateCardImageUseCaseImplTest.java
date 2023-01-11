package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.util.ReflectionTestUtils;
import sem3indiv.domain.Card;
import sem3indiv.domain.CreateCardRequest;
import sem3indiv.domain.UpdateCardImageRequest;
import sem3indiv.domain.UpdateCardRequest;
import sem3indiv.logic.CreateCardUseCase;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.logic.UpdateCardImageUseCase;
import sem3indiv.logic.UpdateCardUseCase;
import sem3indiv.logic.exception.InvalidCardException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UpdateCardImageUseCaseImplTest {

    @Mock
    private CardRepository cardRepositoryMock;

    @Test
    void updateCardImage() {

        CardEntity card2 = CardEntity.builder().id(1L).name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").card_image("url.url").build();
        CreateCardRequest request = CreateCardRequest.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").card_image("url.url").build();
        UpdateCardImageRequest requestImageUpdate = UpdateCardImageRequest.builder().id(1L).name("Updated Card").card_image("update.url").build();

        CreateCardUseCase createCardUseCase = new CreateCardUseCaseImpl(cardRepositoryMock);
        GetCardUseCase getCardUseCase = new GetCardUseCaseImpl(cardRepositoryMock);
        UpdateCardImageUseCase updateCardImageUseCase = new UpdateCardImageUseCaseImpl(cardRepositoryMock);
        when(cardRepositoryMock.findById(any(Long.TYPE))).thenReturn(Optional.of(card2));
        doAnswer(invocation -> {
            ReflectionTestUtils.setField((CardEntity) invocation.getArgument(0), "id", 1L);
            return null;
        }).when(cardRepositoryMock).save(any(CardEntity.class));
        createCardUseCase.createCard(request);

        updateCardImageUseCase.updateCardImage(requestImageUpdate);
        Optional<Card> actualValue = getCardUseCase.getCard(1);
        Card expectedValue = Card.builder().id(1L).name("Updated Card").type("Update Type").desc("This is a Update.")
                .atk(0).def(0).level(0).race("Update").attribute("Update").ogbanlist("None").card_image("update.url").build();

        assertEquals(actualValue.get().getCard_image(), expectedValue.getCard_image());
        verify((cardRepositoryMock), atLeast(2)).save(any(CardEntity.class));
    }

    @Test
    void updateCardImage_ShouldReturnException() {
        UpdateCardImageRequest requestImageUpdate = UpdateCardImageRequest.builder().id(1L).name("Updated Card").card_image("update.url").build();

        UpdateCardImageUseCase updateCardImageUseCase = new UpdateCardImageUseCaseImpl(cardRepositoryMock);
        when(cardRepositoryMock.findById(any(Long.TYPE))).thenReturn(Optional.empty());

        assertThrows(InvalidCardException.class, () -> updateCardImageUseCase.updateCardImage(requestImageUpdate));
        verify((cardRepositoryMock), atLeast(1)).findById(any(Long.TYPE));
    }
}