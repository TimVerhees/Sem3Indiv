package sem3indiv.domain;

import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banlist {
    private Long id;
    private String name;
    private User user;
    //private BanlistItem banlistItem;
}
