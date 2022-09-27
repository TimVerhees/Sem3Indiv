package Sem3Indiv.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCardResponse {
    private Long cardId;
}
