package sem3indiv.domain;

import lombok.*;

@Data
@Builder
public class User {
    private Long id;
    private String type;
    private String name;
    private String username;
    private String password;
}
