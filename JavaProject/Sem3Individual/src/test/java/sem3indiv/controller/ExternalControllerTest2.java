package sem3indiv.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import sem3indiv.domain.UpdateCardImageRequest;
import sem3indiv.logic.AccessTokenDecoder;
import sem3indiv.logic.GetCardUseCase;
import sem3indiv.logic.UpdateCardImageUseCase;
import sem3indiv.logic.exception.InvalidCardException;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.CardEntity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ExternalController.class)
public class ExternalControllerTest2 {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @MockBean
    private AccessTokenDecoder accessTokenDecoderMock;
    @MockBean
    private GetCardUseCase getCardUseCase;
    @MockBean
    private UpdateCardImageUseCase updateCardImageUseCase;
    @Mock
    private CardRepository cardRepositoryMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void updateCardImage() throws Exception{
        CardEntity card2 = CardEntity.builder().id(1L).name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        UpdateCardImageRequest expectedRequest = UpdateCardImageRequest.builder().id(1L).name("Testcard").card_image("https://res.cloudinary.com/dz6wz2wfd/image/upload/v1673447911/Testcard.jpg").build();
        //doThrow(new InvalidCardException("Wrong")).when(updateCardImageUseCase).updateCardImage(expectedRequest);
        when(cardRepositoryMock.findById(any(Long.TYPE))).thenReturn(Optional.of(card2));
        mockMvc.perform(put("/cardimages/updateImage/1")
                        .accept(APPLICATION_JSON_VALUE)
                        .contentType((APPLICATION_JSON_VALUE))
                        .content("""
                                {
                                    "name": "Testcard",
                                    "card_image": "https://i.imgur.com/2z0Jiir.jpg"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isNoContent());
        verify(updateCardImageUseCase).updateCardImage(expectedRequest);
    }
    @Test
    void updateCardImage_ShouldReturnException() throws Exception{

        CardEntity card2 = CardEntity.builder().id(1L).name("Testcard").type("Normal Monster").desc("This is a test card.")
                .atk(500).def(250).level(3).race("Insect").attribute("EARTH").ogbanlist("TCG").build();
        UpdateCardImageRequest expectedRequest = UpdateCardImageRequest.builder().id(1L).name("Testcard").card_image("invalid.url").build();
        //doThrow(new InvalidCardException("Wrong")).when(updateCardImageUseCase).updateCardImage(expectedRequest);
        when(cardRepositoryMock.findById(any(Long.TYPE))).thenReturn(Optional.of(card2));
        mockMvc.perform(put("/cardimages/updateImage/1")
                        .accept(APPLICATION_JSON_VALUE)
                        .contentType((APPLICATION_JSON_VALUE))
                        .content("""
                                {
                                    "name": "Testcard",
                                    "card_image": "invalid.url"
                                }
                                """));

        assertEquals("Failed to upload image", outContent.toString().strip().substring(outContent.toString().strip().indexOf("Failed")));
    }

}
