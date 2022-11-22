package sem3indiv.logic;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.Card;

import java.util.Optional;

public interface GetBanlistUseCase {
    Optional<Banlist> getBanlist(long banlistId);
}
