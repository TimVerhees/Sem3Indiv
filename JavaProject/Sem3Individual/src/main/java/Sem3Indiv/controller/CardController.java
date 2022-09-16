package Sem3Indiv.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Sem3Indiv.domain.GetCardsResponse;
import Sem3Indiv.logic.GetCardsUseCase;

@RestController
@RequestMapping("/cards")
@AllArgsConstructor
public class CardController {
    private final GetCardsUseCase getCardsUseCase;

    @GetMapping
    public ResponseEntity<GetCardsResponse> getCards() {
        return ResponseEntity.ok(getCardsUseCase.getCards());
    }
}
