package sem3indiv.logic.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sem3indiv.domain.Card;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
class CardsImplTest {

    @Mock
    private CardRepository cardRepositoryMock;
    @Test
    void getCards_ShouldReturnAllCardsConverted(){
        //Arrange: Set up code to be used

                CardEntity testEntity =
        CardEntity.builder().id(1L).name("Testcard").type("Monster").build();
                CardEntity magicianEntity =
        CardEntity.builder().id(2L).name("Dark Magician").type("Monster").build();
                when(cardRepositoryMock.findAll())
                    .thenReturn(List.of(testEntity, magicianEntity));

        Card testCard = Card.builder().id(1L).name("Testcard").type("Monster").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").type("Monster").build();

        //Act: Execute the method to be tested
        GetCardsUseCaseImpl getCardsUseCase = new
                GetCardsUseCaseImpl(cardRepositoryMock);
        GetCardsResponse actualResult =
                getCardsUseCase.getCards();

        GetCardsResponse expectedResult = GetCardsResponse
                .builder()
                .cards(List.of(testCard, magicianCard))
                .build();

        //Assert: Check if the method postconditions is as expected
        assertEquals(actualResult, expectedResult);
        verify(cardRepositoryMock).findAll();
    }

    @Test
    void getCard_ShouldReturnCardById(){
        CardEntity testEntity = CardEntity.builder().id(1L).name("Testcard").build();
        CardEntity magicianEntity = CardEntity.builder().id(2L).name("Dark Magician").build();
        when(cardRepositoryMock.findById(1L)).thenReturn(Optional.ofNullable(testEntity));

        Card testCard = Card.builder().id(1L).name("Testcard").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").build();

        GetCardUseCaseImpl getCardUseCase = new GetCardUseCaseImpl(cardRepositoryMock);
        Optional<Card> actualRestult = getCardUseCase.getCard(1);

        verify(cardRepositoryMock).findById(anyLong());
    }

}