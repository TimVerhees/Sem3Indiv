package Sem3Indiv.controller;

import Sem3Indiv.domain.*;
import Sem3Indiv.logic.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {
    private final GetCardsUseCase getCardsUseCase;
    private final GetCardUseCase getCardUseCase;
    private final CreateCardUseCase createCardUseCase;
    private final UpdateCardUseCase updateCardUseCase;
    private final DeleteCardUseCase deleteCardUseCase;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<GetCardsResponse> getCards() {
        return ResponseEntity.ok(getCardsUseCase.getCards());
    }

    @CrossOrigin
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
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCard(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateCardRequest request) {
        request.setId(id);
        updateCardUseCase.updateCard(request);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable int cardId) {
        deleteCardUseCase.deleteCard(cardId);
        return ResponseEntity.noContent().build();

    }
}
