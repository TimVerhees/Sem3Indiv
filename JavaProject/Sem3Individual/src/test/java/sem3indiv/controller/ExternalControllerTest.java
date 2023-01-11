package sem3indiv.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sem3indiv.domain.Card;
import sem3indiv.domain.UpdateCardImageRequest;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.logic.UpdateCardImageUseCase;
import sem3indiv.logic.exception.InvalidCardException;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)

class ExternalControllerTest {

    @Mock
    private GetCardUseCase getCardUseCase;
    @Mock
    private UpdateCardImageUseCase updateCardImageUseCase;


    @Test
    void getExternalCard_ShouldReturnImageLink(){
        String cardName ="El Shaddoll Winda";

        ExternalController externalController = new ExternalController(getCardUseCase, updateCardImageUseCase);
        String actualValue = externalController.getCardExternal(cardName);
        String expectedValue = "{\"data\":[{\"id\":94977270,\"name\":\"El Shaddoll Winda\",\"type\":\"Fusion Monster\",\"frameType\":\"fusion\",\"desc\":\"1 \\\"Shaddoll\\\" monster + 1 DARK monster\\r\\nMust first be Fusion Summoned. Cannot be destroyed by an opponent's card effects. Each player can only Special Summon monster(s) once per turn while this card is face-up on the field. If this card is sent to the GY: You can target 1 \\\"Shaddoll\\\" Spell/Trap in your GY; add it to your hand.\",\"atk\":2200,\"def\":800,\"level\":5,\"race\":\"Spellcaster\",\"attribute\":\"DARK\",\"archetype\":\"Shaddoll\",\"card_sets\":[{\"set_name\":\"2015 Mega-Tin Mega Pack\",\"set_code\":\"MP15-EN093\",\"set_rarity\":\"Ultra Rare\",\"set_rarity_code\":\"(UR)\",\"set_price\":\"8.14\"},{\"set_name\":\"Duelist Alliance\",\"set_code\":\"DUEA-EN048\",\"set_rarity\":\"Ultra Rare\",\"set_rarity_code\":\"(UR)\",\"set_price\":\"11.24\"},{\"set_name\":\"Shadows in Valhalla\",\"set_code\":\"SHVA-EN049\",\"set_rarity\":\"Secret Rare\",\"set_rarity_code\":\"(ScR)\",\"set_price\":\"8.96\"},{\"set_name\":\"Structure Deck: Shaddoll Showdown\",\"set_code\":\"SDSH-EN047\",\"set_rarity\":\"Super Rare\",\"set_rarity_code\":\"(SR)\",\"set_price\":\"4.31\"}],\"card_images\":[{\"id\":94977270,\"image_url\":\"https://images.ygoprodeck.com/images/cards/94977270.jpg\",\"image_url_small\":\"https://images.ygoprodeck.com/images/cards_small/94977270.jpg\",\"image_url_cropped\":\"https://images.ygoprodeck.com/images/cards_cropped/94977270.jpg\"},{\"id\":94977269,\"image_url\":\"https://images.ygoprodeck.com/images/cards/94977269.jpg\",\"image_url_small\":\"https://images.ygoprodeck.com/images/cards_small/94977269.jpg\",\"image_url_cropped\":\"https://images.ygoprodeck.com/images/cards_cropped/94977269.jpg\"}],\"card_prices\":[{\"cardmarket_price\":\"1.69\",\"tcgplayer_price\":\"1.67\",\"ebay_price\":\"6.25\",\"amazon_price\":\"4.54\",\"coolstuffinc_price\":\"2.99\"}]}]}";

        assertEquals(actualValue, expectedValue);
    }


}