package sem3indiv.controller;

import sem3indiv.config.security.isauthenticated.IsAuthenticated;
import sem3indiv.domain.*;
import sem3indiv.logic.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("//localhost:3000")
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {
    private final GetCardsUseCase getCardsUseCase;
    private final GetCardUseCase getCardUseCase;
    private final CreateCardUseCase createCardUseCase;
    private final UpdateCardUseCase updateCardUseCase;
    private final DeleteCardUseCase deleteCardUseCase;

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<GetCardsResponse> getCards() {
        return ResponseEntity.ok(getCardsUseCase.getCards());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Card> getCard(@PathVariable(value = "id") final long id) {
        final Optional<Card> cardOptional = getCardUseCase.getCard(id);
        if (cardOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cardOptional.get());
    }
    @IsAuthenticated
    @RolesAllowed("ROLE_Admin")
    @PostMapping()
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<CreateCardResponse> createCard(@RequestBody @Valid CreateCardRequest request) {
        CreateCardResponse response = createCardUseCase.createCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @CrossOrigin("http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCard(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateCardRequest request) {
        request.setId(id);
        updateCardUseCase.updateCard(request);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin("http://localhost:3000")
    @Transactional
    @DeleteMapping("{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable int cardId) {
        deleteCardUseCase.deleteCard(cardId);
        return ResponseEntity.noContent().build();

    }
}
