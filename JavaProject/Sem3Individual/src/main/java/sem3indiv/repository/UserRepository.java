package sem3indiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem3indiv.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
    //boolean existsByCode(String code);

    boolean existsById(long userId);

    UserEntity findById(long userId);
    UserEntity findByUsername(String username);

    UserEntity save(UserEntity banlist);

    List<UserEntity> findAll();

    //int count();
}
