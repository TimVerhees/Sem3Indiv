package sem3indiv.logic.impl;

import sem3indiv.domain.Card;
import sem3indiv.repository.entity.CardEntity;

public class CardConvertor {
    private CardConvertor() {

    }
    public static Card convert(CardEntity card) {
        return Card.builder()
                .id(card.getId())
                .name(card.getName())
                .type(card.getType())
                .desc(card.getDesc())
                .atk(card.getAtk())
                .def(card.getDef())
                .level(card.getLevel())
                .race(card.getRace())
                .attribute(card.getAttribute())
                .link(card.getLink())
                .ogbanlist(card.getOgbanlist())
                .build();
    }
}
