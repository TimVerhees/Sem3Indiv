package sem3indiv.logic;


import sem3indiv.domain.CreateBanlistRequest;
import sem3indiv.domain.CreateBanlistResponse;

public interface CreateBanlistUseCase {
    CreateBanlistResponse createBanlist(CreateBanlistRequest request);
}
