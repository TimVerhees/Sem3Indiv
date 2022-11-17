package sem3indiv.logic.impl;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.Card;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;

public class BanlistConvertor {

    private BanlistConvertor() {

    }
    public static Banlist convert(BanlistEntity banlistEntity) {
        return Banlist.builder()
                .id(banlistEntity.getId())
                .name(banlistEntity.getName())
                .user(UserConvertor.convert(banlistEntity.getUser()))
                .build();
    }
}
