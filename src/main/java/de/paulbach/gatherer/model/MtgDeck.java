package de.paulbach.gatherer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "mtg_deck")
public class MtgDeck {

    @Id
    public String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="card_deck",
            joinColumns=@JoinColumn(name="deck_id", referencedColumnName="name"),
            inverseJoinColumns=@JoinColumn(name="card_id", referencedColumnName="id"))
    public List<MtgCard> deck;
}
