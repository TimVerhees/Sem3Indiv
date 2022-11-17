package sem3indiv.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String type;
    private String username;
    private String password;
    //private List<Banlist> banlists;
}
