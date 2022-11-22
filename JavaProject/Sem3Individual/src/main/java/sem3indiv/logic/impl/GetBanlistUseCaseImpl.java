package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sem3indiv.domain.Banlist;
import sem3indiv.domain.Card;
import sem3indiv.domain.GetBanlistsResponse;
import sem3indiv.domain.GetCardsResponse;
import sem3indiv.logic.GetBanlistsUseCase;
import sem3indiv.repository.BanlistRepository;
import sem3indiv.repository.CardRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;

import java.util.List;
@Service
@AllArgsConstructor
@Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class GetBanlistUseCaseImpl implements GetBanlistsUseCase {
    public BanlistRepository banlistRepository;

    @Override
    public GetBanlistsResponse getBanlists(){
        List<Banlist> banlists = findAll()
                .stream()
                .map(BanlistConvertor::convert)
                .toList();
        return GetBanlistsResponse.builder()
                .banlists(banlists)
                .build();
    }

    private List<BanlistEntity> findAll() {
        // TODO: replace by country repository method call

        return banlistRepository.findAll();
    }
}
