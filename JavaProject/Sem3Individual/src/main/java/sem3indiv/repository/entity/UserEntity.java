package sem3indiv.repository.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sem3indiv.domain.Banlist;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @NotNull
    @Column (name = "type")
    private String type;
    @NotNull
    @Column (name = "username")
    private String username;
    @NotNull
    @Column (name = "password")
    private String password;
    //@OneToMany (mappedBy = "user")
    //private List<BanlistEntity> banlists;
}
