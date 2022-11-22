package sem3indiv.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem3indiv.domain.BanlistItem;
import sem3indiv.domain.Card;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "banlistitem")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BanlistItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @ManyToMany
    @JoinTable(
            name = "banlist_card",
            joinColumns = @JoinColumn (name = "banlistitem_id"),
            inverseJoinColumns = @JoinColumn (name = "card_id"))
    private List<CardEntity> cards;
    /*@NotNull
    @OneToMany (mappedBy = "banlistitem")
    private List<BanlistEntity> banlist;*/
    @NotNull
    @Column (name = "bantype")
    private String bantype;
}
