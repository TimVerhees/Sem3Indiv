package sem3indiv.logic.impl;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.BanlistItem;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.BanlistItemEntity;

import java.util.ArrayList;
import java.util.List;

public class BanlistItemConvertor {

    private BanlistItemConvertor() {}

    public static BanlistItem convert(BanlistItemEntity banlistItemEntity) {
        return BanlistItem.builder()
                .id(banlistItemEntity.getId())
                .cards(CardConvertor.convert(banlistItemEntity.getCards()))
                .bantype(banlistItemEntity.getBantype())
                .build();
    }

    public static List<BanlistItem> convert(List<BanlistItemEntity> banlistItemEntities) {
        List<BanlistItem> temp = new ArrayList<>();
        if (banlistItemEntities == null) {
            return temp;
        }
        for (BanlistItemEntity banlistItemEntity : banlistItemEntities) {
            temp.add(convert(banlistItemEntity));
        }
        return temp;
    }
}
