package sem3indiv.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import sem3indiv.domain.*;
import sem3indiv.logic.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BanlistController.class)
class BanlistControllerTest {
    @MockBean
    private AccessTokenDecoder accessTokenDecoderMock;
    @MockBean
    private GetBanlistsUseCase getBanlistsUseCase;
    @MockBean
    private GetCardUseCase getCardUseCaseUseCase;
    @MockBean
    private UpdateCardImageUseCase updateCardImageUseCase;
    @MockBean
    private CreateBanlistUseCase createBanlistUseCase;
    @MockBean
    private GetBanlistUseCase getBanlistUseCase;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBanlists() throws Exception{
        Card cardB1 = Card.builder().name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        Card cardB2 = Card.builder().name("TestcardLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        Card cardB3 = Card.builder().name("TestcardSemiLimited").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        List<Card> cardlistB1 = new ArrayList<>();
        List<Card> cardlistB2 = new ArrayList<>();
        List<Card> cardlistB3 = new ArrayList<>();
        cardlistB1.add(cardB1);
        cardlistB2.add(cardB2);
        cardlistB3.add(cardB3);
        BanlistItem itemBOne = BanlistItem.builder().id(1).bantype("Forbidden").cards(cardlistB1).build();
        BanlistItem itemBTwo = BanlistItem.builder().id(2).bantype("Limited").cards(cardlistB2).build();
        BanlistItem itemBThree = BanlistItem.builder().id(3).bantype("Semi-Limited").cards(cardlistB3).build();
        BanlistItem itemBFour = BanlistItem.builder().id(4).bantype("Forbidden").cards(cardlistB2).build();
        BanlistItem itemBFive = BanlistItem.builder().id(5).bantype("Limited").cards(cardlistB3).build();
        BanlistItem itemBSix = BanlistItem.builder().id(6).bantype("Semi-Limited").cards(cardlistB1).build();
        List<BanlistItem> itemListBase1 = new ArrayList<>();
        itemListBase1.add(itemBOne);
        itemListBase1.add(itemBTwo);
        itemListBase1.add(itemBThree);
        List<BanlistItem> itemListBase2 = new ArrayList<>();
        itemListBase2.add(itemBFour);
        itemListBase2.add(itemBFive);
        itemListBase2.add(itemBSix);
        User user = User.builder().username("TestUser").password("Bruh").type("User").build();
        Banlist banlist1 = Banlist.builder().id(1L).banlistItems(itemListBase1).user(user).name("Banlist Number One").build();
        Banlist banlist2 = Banlist.builder().id(2L).banlistItems(itemListBase2).user(user).name("Banlist Number Two").build();
        List<Banlist> banlists = new ArrayList<>();
        banlists.add(banlist1);
        banlists.add(banlist2);

        GetBanlistsResponse response = GetBanlistsResponse.builder().banlists(banlists).build();
        when(getBanlistsUseCase.getBanlists()).thenReturn(response);

        mockMvc.perform(get("/banlists"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE));
        verify((getBanlistsUseCase), atLeast(1)).getBanlists();
        verifyNoInteractions(createBanlistUseCase);
    }
}