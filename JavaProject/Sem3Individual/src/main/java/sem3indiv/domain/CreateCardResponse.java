package sem3indiv.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import sem3indiv.repository.entity.CardEntity;

@Data
@Builder
public class CreateCardResponse
        //extends JpaRepository<CardEntity, Long>
{
    private Long cardId;
}
