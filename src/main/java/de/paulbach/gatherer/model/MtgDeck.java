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
public class MtgDeck {

    @Id
    public String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    public List<MtgCard> deck;
}
