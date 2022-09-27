package Sem3Indiv.domain;

import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banlist {
    private Long id;
    private Card card;
    private User user;
    private List<SubList>subLists;
}
