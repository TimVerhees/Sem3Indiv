package sem3indiv.repository.entity;

import sem3indiv.domain.Banlist;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private Long id;
    private String type;
    private String name;
    private String username;
    private String password;
    private Banlist banlist;
}
