package sem3indiv.logic.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3indiv.domain.Banlist;
import sem3indiv.logic.GetBanlistUseCase;
import sem3indiv.repository.BanlistRepository;

import java.util.Optional;
@Service
@AllArgsConstructor
public class GetBanlistByIdImpl implements GetBanlistUseCase {
    private BanlistRepository banlistRepository;

    @Override
    public Optional<Banlist> getBanlist(long banlistId) {
        return banlistRepository.findById(banlistId).map(BanlistConvertor::convert);
    }
}
