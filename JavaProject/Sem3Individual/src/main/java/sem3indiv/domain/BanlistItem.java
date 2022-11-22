package sem3indiv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BanlistItem {
    private int id;
    private List<Card> cards;
    //private List<Banlist> banlist;
    private String bantype;

}
