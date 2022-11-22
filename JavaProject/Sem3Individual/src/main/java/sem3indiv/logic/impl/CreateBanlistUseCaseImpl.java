package sem3indiv.logic.impl;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.domain.CreateBanlistRequest;
import sem3indiv.domain.CreateBanlistResponse;
import sem3indiv.logic.CreateBanlistUseCase;
import sem3indiv.logic.exception.NameAlreadyExistsException;
import sem3indiv.repository.BanlistRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;
import sem3indiv.repository.entity.UserEntity;

@Service
@AllArgsConstructor
public class CreateBanlistUseCaseImpl  implements CreateBanlistUseCase {

    private BanlistRepository banlistRepository;

    @Override
    public CreateBanlistResponse createBanlist(CreateBanlistRequest request) {
        BanlistEntity newBanlist = BanlistEntity.builder()
                .name(request.getName())
                .user(request.getUser())
                .banlistitems(request.getBanlistItems())
                .build();

        BanlistEntity savedBanlist = saveNewBanlist(newBanlist);

        return CreateBanlistResponse.builder()
                .banlistId(savedBanlist.getId())
                .build();
    }

    private BanlistEntity saveNewBanlist(BanlistEntity banlist) {

        banlistRepository.save((banlist));
        return BanlistEntity.builder().build();
    }

    //private boolean existsByName(String cardName) {
        // TODO: replace by countryRepository correct method call and return
        //return (cardRepository.existsByName(cardName));
}
