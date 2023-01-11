package sem3indiv.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import sem3indiv.domain.Card;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.logic.*;
import sem3indiv.repository.entity.CardEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CardController.class)
class CardControllerTest {
    @MockBean
    private AccessTokenDecoder accessTokenDecoderMock;
    @MockBean
    private GetCardUseCase getCardUseCaseUseCase;
    @MockBean
    private UpdateCardImageUseCase updateCardImageUseCase;
    @MockBean
    private GetCardsUseCase getCardsUseCase;
    @MockBean
    private CreateCardUseCase createCardUseCase;
    @MockBean
    private UpdateCardUseCase updateCardUseCase;
    @MockBean
    private DeleteCardUseCase deleteCardUseCase;

    @Autowired
    private MockMvc mockMvc;
    @Test
    void getCards() throws Exception{
        Card testCard = Card.builder().id(1L).name("Testcard").type("Monster").build();
        Card magicianCard = Card.builder().id(2L).name("Dark Magician").type("Monster").build();
        List<Card> cards = new ArrayList<>();
        cards.add(testCard);
        cards.add(magicianCard);
        GetCardsResponse response = GetCardsResponse.builder().cards(cards).build();
        when(getCardsUseCase.getCards())
                .thenReturn(response);
        mockMvc.perform(get("/cards"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE));
        verify((getCardsUseCase), atLeast(1)).getCards();
        verifyNoInteractions(createCardUseCase);
    }
}