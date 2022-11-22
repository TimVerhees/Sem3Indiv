package sem3indiv.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem3indiv.domain.BanlistItem;
import sem3indiv.domain.Card;
import sem3indiv.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table (name = "banlists")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BanlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @NotNull
    @Column (name = "name")
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn (name = "user_id")
    private UserEntity user;
    @OneToMany
    @JoinColumn (name = "banlist_id")
    @NotNull
    private List<BanlistItemEntity> banlistitems;
}
