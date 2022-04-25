package de.paulbach.gatherer.service.implementation;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.MtgDeck;
import de.paulbach.gatherer.repository.CardRepository;
import de.paulbach.gatherer.repository.DeckRepository;
import de.paulbach.gatherer.service.GathererService;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GathererServiceImpl implements GathererService {

    private final CardRepository cardRepository;

    private final DeckRepository deckRepository;


    @Override
    public MtgCard add(String name) {
        List<Card> cards = CardAPI.getAllCards(List.of("name=" + name));

        Card card = cards.stream().filter(item -> item.getMultiverseid() != -1).collect(Collectors.toList()).get(0);


        MtgCard mtgCard = MtgCard.builder()
                .manaCost(card.getManaCost())
                .name(card.getName())
                .multiverseId(card.getMultiverseid())
                .text(card.getOriginalText())
                .build();

        return cardRepository.save(mtgCard);
    }

    @Override
    public MtgCard get(Long id) {
        return this.cardRepository.findById(id).get();
    }

    @Override
    public MtgDeck addDeck(MtgDeck deck) {
        return this.deckRepository.save(deck);
    }

    @Override
    public MtgDeck getDeck(String name) {
        return this.deckRepository.getById(name);
    }
}
