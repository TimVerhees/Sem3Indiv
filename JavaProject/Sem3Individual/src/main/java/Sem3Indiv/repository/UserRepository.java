package Sem3Indiv.repository;

import Sem3Indiv.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    boolean existsByCode(String code);

    boolean existsById(long banlistId);

    UserEntity findById(long userId);

    UserEntity save(UserEntity banlist);

    List<UserEntity> findAll();

    int count();
}
