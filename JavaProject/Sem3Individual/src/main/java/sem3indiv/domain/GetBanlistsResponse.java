package sem3indiv.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetBanlistsResponse {
    private List<Banlist> banlists;
}
