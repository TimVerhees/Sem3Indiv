package Sem3Indiv.repository.impl;

import org.springframework.stereotype.Repository;
import Sem3Indiv.repository.CardRepository;
import Sem3Indiv.repository.entity.CardEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeCardRepositoryImpl implements CardRepository {
    private static long NEXT_ID = 1;
    private final List<CardEntity> savedCards;

    public FakeCardRepositoryImpl() {
        this.savedCards = new ArrayList<>();
    }

    @Override
    public boolean existsById(long cardId) {
        return this.savedCards
                .stream()
                .anyMatch(cardEntity -> cardEntity.getId() == cardId);
    }
    /*@Override
    public CardEntity findById(long cardId) {
        return this.savedCards
                .stream()
                .filter(cardEntity -> cardEntity.getId() == cardId)
                .findFirst()
                .orElse(null);
    }*/
    @Override
    public boolean existsByName(String name) {
        return this.savedCards
                .stream()
                .anyMatch(cardEntity -> cardEntity.getName().equals(name));
    }
    @Override
    public CardEntity save(CardEntity card) {
        card.setId(NEXT_ID);
        NEXT_ID++;
        this.savedCards.add(card);
        return card;
    }
    @Override
    public void deleteById(Long cardId) {
        this.savedCards.removeIf(cardEntity -> cardEntity.getId().equals(cardId));
    }
    @Override
    public List<CardEntity> findAll() {
        return Collections.unmodifiableList(savedCards);
    }

    @Override
    public Optional<CardEntity> findById(long cardId) {
        return this.savedCards.stream()
                .filter(cardEntity -> cardEntity.getId().equals(cardId))
                .findFirst();
    }

    @Override
    public int count() {
        return this.savedCards.size();
    }
}
