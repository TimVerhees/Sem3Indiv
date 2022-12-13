package sem3indiv.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {
    private String subject;
    private String role;
    private long userId;

    @JsonIgnore
    public boolean hasRole(String roleName) {
        if (role == null) {
            return false;
        }
        return role.contains(roleName);
    }
}
