package de.paulbach.gatherer.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name="mtg_card")
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

    @Getter
    @Setter
    private String imageUrl;

    @Getter
    @Setter
    private int quantity;

}
