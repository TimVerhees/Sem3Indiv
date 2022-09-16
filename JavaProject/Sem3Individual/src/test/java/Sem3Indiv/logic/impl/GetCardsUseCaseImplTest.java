package Sem3Indiv.logic.impl;

import Sem3Indiv.domain.Card;
import Sem3Indiv.domain.GetCardsResponse;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.repository.entity.CardEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GetCardsUseCaseImplTest {

    @Test
    void getCards_ShouldReturnAllCardsConverted(){
        //Arrange: Set up code to be used
        CardRepository cardRepositoryMock =
mock(CardRepository.class);

        CardEntity testEntity =
CardEntity.builder().id(1L).name("Testcard").build();
        CardEntity magicianEntity =
CardEntity.builder().id(2L).name("Dark Magician").build();
        when(cardRepositoryMock.findAll())
            .thenReturn(List.of(testEntity, magicianEntity));

        Card testCard = Card.builder().id(1L).name("Testcard").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").build();

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


}