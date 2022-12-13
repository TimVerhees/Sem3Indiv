package sem3indiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem3indiv.domain.Card;
import sem3indiv.repository.entity.CardEntity;

import java.util.List;
import java.util.Optional;

public interface CardRepository  extends JpaRepository<CardEntity, Long> {


    boolean existsById(long cardId);

    //CardEntity findById(long cardId);

    //boolean existsByName(String name);
    Optional<CardEntity> findByName(String name);

    boolean existsByName(String cardName);
    //CardEntity save(CardEntity card);

    //List<CardEntity> findAll();

    //void deleteById(Long cardId);

    //int count();
    //boolean findById(long cardId);
}
