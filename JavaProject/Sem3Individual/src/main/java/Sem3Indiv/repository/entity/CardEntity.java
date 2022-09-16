package Sem3Indiv.repository.entity;

import lombok.*;

@Data
@Builder
public class CardEntity {
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
