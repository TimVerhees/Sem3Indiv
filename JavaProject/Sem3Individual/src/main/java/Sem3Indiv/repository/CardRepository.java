package Sem3Indiv.repository;

import Sem3Indiv.repository.entity.CardEntity;

import java.util.List;
import java.util.Optional;

public interface CardRepository {


    boolean existsById(long cardId);

    //CardEntity findById(long cardId);

    boolean existsByName(String name);

    CardEntity save(CardEntity card);

    List<CardEntity> findAll();

    void deleteById(Long cardId);

    int count();
    Optional<CardEntity> findById(long cardId);
}
