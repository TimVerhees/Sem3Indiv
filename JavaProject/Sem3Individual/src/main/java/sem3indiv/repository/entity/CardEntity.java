package sem3indiv.repository.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.mysql.cj.MysqlType.LONGTEXT;

@Entity
@Data
@Builder
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @NotNull
    @Column (name = "name")
    private String name;
    @NotNull
    @Column (name = "type")
    private String type;

    @Column (name = "desc")
    @Type(type="text")
    private String desc;
    @Column (name = "atk")
    private int atk;
    @Column (name = "def")
    private int def;
    @Column (name = "level")
    private int level;
    @Column (name = "race")
    private String race;
    @Column (name = "attribute")
    private String attribute;
    @Column (name = "link")
    private int link;
    @Column (name = "ogbanlist")
    private String ogbanlist;
    //USE JACOCO FOR SONAR

}
