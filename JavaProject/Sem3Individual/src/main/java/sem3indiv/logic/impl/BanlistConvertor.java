package sem3indiv.logic.impl;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.Card;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.BanlistItemEntity;
import sem3indiv.repository.entity.CardEntity;

import java.util.ArrayList;
import java.util.List;

public class BanlistConvertor {

    private BanlistConvertor() {

    }
    public static Banlist convert(BanlistEntity banlistEntity) {
        return Banlist.builder()
                .id(banlistEntity.getId())
                .name(banlistEntity.getName())
                .user(UserConvertor.convert(banlistEntity.getUser()))
                .banlistItems(BanlistItemConvertor.convert(banlistEntity.getBanlistitems()))
                .build();
    }

    /*public static List<Banlist> convert(List<BanlistEntity> banlistEntities) {
        List<Banlist> temp = new ArrayList<>();
        if (banlistEntities == null) {
            return temp;
        }
        for (BanlistEntity banlistEntity : banlistEntities) {
            temp.add(convert(banlistEntity));
        }
        return temp;
    }*/
}
