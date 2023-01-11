package sem3indiv.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBanlistResponse {
    private Long banlistId;
    private String name;
}
