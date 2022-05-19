package de.paulbach.gatherer.service;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.MtgDeck;

import java.util.List;

public interface CardService {

    MtgCard addCard(String name, int quantity);

    MtgCard getCard(Long id);

}
