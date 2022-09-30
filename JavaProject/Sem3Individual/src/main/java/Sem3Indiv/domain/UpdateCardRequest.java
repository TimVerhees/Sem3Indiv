package Sem3Indiv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardRequest {

    private Long id;

    private String name;

    private String type;

    private String desc;

    private int atk;

    private int def;

    private int level;

    private String race;

    private String attribute;

    private int link;

    private String ogbanlist;
}
