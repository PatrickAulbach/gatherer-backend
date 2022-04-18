package de.paulbach.gatherer.model;

import io.magicthegathering.javasdk.resource.Card;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MtgCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String manaCost;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private int multiverseId;

}
