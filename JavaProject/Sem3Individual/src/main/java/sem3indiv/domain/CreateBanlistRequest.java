package sem3indiv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem3indiv.repository.entity.BanlistItemEntity;
import sem3indiv.repository.entity.UserEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBanlistRequest {
    @NotNull
    private String name;

    private List<BanlistItemEntity> banlistItems;
    @NotNull
    private UserEntity user;
}
