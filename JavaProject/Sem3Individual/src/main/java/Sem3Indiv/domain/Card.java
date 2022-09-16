package Sem3Indiv.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private String name;
    private String type;
    private String desc;
    private String atk;
    private String def;
    private int level;
    private String race;
    private String attribute;
    private int link;
    private String ogbanlist;
}
