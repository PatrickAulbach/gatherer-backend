package de.paulbach.gatherer.service.implementation;

import de.paulbach.gatherer.model.MtgDeck;
import de.paulbach.gatherer.repository.DeckRepository;
import de.paulbach.gatherer.service.DeckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DeckServiceImpl implements DeckService {

    private final DeckRepository deckRepository;

    @Override
    public MtgDeck addDeck(MtgDeck deck) {
        return this.deckRepository.save(deck);
    }

    @Override
    public MtgDeck getDeck(String name) {
        return this.deckRepository.getById(name);
    }
}
