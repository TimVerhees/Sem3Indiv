package sem3indiv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import sem3indiv.repository.entity.CardEntity;

import java.util.List;
@Data
@Builder
public class GetCardsResponse{
    private List<Card> cards;
}
