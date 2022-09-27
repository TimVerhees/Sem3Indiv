package Sem3Indiv.controller;

import Sem3Indiv.domain.Card;
import Sem3Indiv.domain.CreateCardRequest;
import Sem3Indiv.domain.CreateCardResponse;
import Sem3Indiv.logic.CreateCardUseCase;
import Sem3Indiv.logic.GetCardUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Sem3Indiv.domain.GetCardsResponse;
import Sem3Indiv.logic.GetCardsUseCase;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {
    private final GetCardsUseCase getCardsUseCase;
    private final GetCardUseCase getCardUseCase;
    private final CreateCardUseCase createCardUseCase;

    @GetMapping
    public ResponseEntity<GetCardsResponse> getCards() {
        return ResponseEntity.ok(getCardsUseCase.getCards());
    }

    @GetMapping("{id}")
    public ResponseEntity<Card> getCard(@PathVariable(value = "id") final long id) {
        final Optional<Card> cardOptional = getCardUseCase.getCard(id);
        if (cardOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cardOptional.get());
    }

    @PostMapping()
    public ResponseEntity<CreateCardResponse> createCard(@RequestBody @Valid CreateCardRequest request) {
        CreateCardResponse response = createCardUseCase.createCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
