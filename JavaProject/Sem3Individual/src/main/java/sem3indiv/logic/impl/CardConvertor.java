package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.repository.entity.CardEntity;

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
                .build();
    }
}
