package de.paulbach.gatherer.service;

import de.paulbach.gatherer.model.MtgDeck;

public interface DeckService {

    MtgDeck addDeck(MtgDeck deck);

    MtgDeck getDeck(String name);
}
