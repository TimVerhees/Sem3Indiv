package sem3indiv.logic.impl;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.Card;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;

import java.util.ArrayList;
import java.util.List;

public class CardConvertor {
    private CardConvertor() {

    }
    public static Card convert(CardEntity cardEntity) {
        return Card.builder()
                .id(cardEntity.getId())
                .name(cardEntity.getName())
                .type(cardEntity.getType())
                .desc(cardEntity.getDesc())
                .atk(cardEntity.getAtk())
                .def(cardEntity.getDef())
                .level(cardEntity.getLevel())
                .race(cardEntity.getRace())
                .attribute(cardEntity.getAttribute())
                .link(cardEntity.getLink())
                .ogbanlist(cardEntity.getOgbanlist())
                .card_image(cardEntity.getCard_image())
                .build();
    }

    public static List<Card> convert(List<CardEntity> cardEntities) {
        List<Card> temp = new ArrayList<>();
        if (cardEntities == null) {
            return temp;
        }
        for (CardEntity cardEntity : cardEntities) {
            temp.add(convert(cardEntity));
        }
        return temp;
    }
}
