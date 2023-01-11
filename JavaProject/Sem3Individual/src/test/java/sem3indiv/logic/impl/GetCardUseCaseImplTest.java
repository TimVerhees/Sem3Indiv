package sem3indiv.logic.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sem3indiv.domain.Card;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class GetCardUseCaseImplTest {

    @Mock
    private CardRepository cardRepositoryMock;

    @Test
    void getCardName() {

        CardEntity testEntity =
                CardEntity.builder().id(1L).name("Testcard").type("Monster").build();
        CardEntity magicianEntity =
                CardEntity.builder().id(2L).name("Dark Magician").type("Monster").build();
        when(cardRepositoryMock.findByName("Testcard"))
                .thenReturn(Optional.ofNullable(testEntity));

        Card testCard = Card.builder().id(1L).name("Testcard").type("Monster").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").type("Monster").build();

        GetCardUseCaseImpl getCardUseCase = new GetCardUseCaseImpl(cardRepositoryMock);
        String actualResult = getCardUseCase.getCardName(testEntity.getName());
        String expectedResult = "Testcard";
        assertEquals(actualResult, expectedResult);
        verify(cardRepositoryMock).findByName(anyString());

    }
    @Test
    void getCardName_ShouldReturnNull() {

        CardEntity testEntity =
                CardEntity.builder().id(1L).name("Testcard").type("Monster").build();
        CardEntity magicianEntity =
                CardEntity.builder().id(2L).name("Dark Magician").type("Monster").build();
        when(cardRepositoryMock.findByName("NonExist"))
                .thenReturn(Optional.empty());

        Card testCard = Card.builder().id(1L).name("Testcard").type("Monster").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").type("Monster").build();

        GetCardUseCaseImpl getCardUseCase = new GetCardUseCaseImpl(cardRepositoryMock);
        String actualResult = getCardUseCase.getCardName("NonExist");
        String expectedResult = null;
        assertEquals(actualResult, expectedResult);
        verify(cardRepositoryMock).findByName("NonExist");

    }
}