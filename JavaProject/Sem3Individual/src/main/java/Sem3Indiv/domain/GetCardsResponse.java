package Sem3Indiv.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetCardsResponse {
    private List<Card> cards;
}
