package Sem3Indiv.repository;

import Sem3Indiv.repository.entity.CardEntity;

import java.util.List;

public interface CardRepository {


    boolean existsById(long cardId);

    CardEntity findById(long cardId);

    CardEntity save(CardEntity card);

    List<CardEntity> findAll();

    int count();
}
