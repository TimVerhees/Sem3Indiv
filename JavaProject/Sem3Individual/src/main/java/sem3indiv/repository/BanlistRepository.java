package sem3indiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem3indiv.repository.entity.BanlistEntity;
import sem3indiv.repository.entity.CardEntity;

import java.util.List;
import java.util.Optional;

public interface BanlistRepository extends JpaRepository<BanlistEntity, Long>  {
    boolean existsById(long banlistId);

    boolean existsByName(String name);

    BanlistEntity save(BanlistEntity card);

    List<BanlistEntity> findAll();

    void deleteById(Long banlistId);

    //int count();
    Optional<BanlistEntity> findById(long banlistId);
}
