package de.paulbach.gatherer.service;

import de.paulbach.gatherer.model.MtgCard;

public interface GathererService {

    MtgCard add(String name);

    MtgCard get(Long id);
}
