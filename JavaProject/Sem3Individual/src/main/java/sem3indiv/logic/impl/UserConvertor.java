package sem3indiv.logic.impl;

import sem3indiv.domain.Banlist;
import sem3indiv.domain.User;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.UserEntity;

public class UserConvertor {
    private UserConvertor() {

    }
    public static User convert(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .type(userEntity.getType())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                //.banlists(BanlistConvertor.convert(userEntity.getBanlists()))
                .build();
    }
}
