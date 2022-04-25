package de.paulbach.gatherer.service;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.MtgDeck;

import java.util.List;

public interface GathererService {

    MtgCard add(String name);

    MtgCard get(Long id);

    MtgDeck addDeck(MtgDeck deck);

    MtgDeck getDeck(String name);
}
