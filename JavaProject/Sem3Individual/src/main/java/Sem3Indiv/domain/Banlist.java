package Sem3Indiv.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banlist {
    private Long id;
    private Card card;
}
