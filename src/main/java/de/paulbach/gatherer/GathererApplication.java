package de.paulbach.gatherer;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.MtgDeck;
import de.paulbach.gatherer.repository.DeckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GathererApplication {

    public static void main(String[] args) {
        SpringApplication.run(GathererApplication.class, args);
    }

    @Bean
    CommandLineRunner run(DeckRepository deckRepository) {
        MtgDeck mtgDeck = new MtgDeck();
        List<MtgCard> cards = Arrays.asList(
                MtgCard.builder().manaCost("1").multiverseId(1).name("deck 1").text("hello").build(),
                MtgCard.builder().manaCost("2").multiverseId(2).name("deck 2").text("world").build(),
                MtgCard.builder().manaCost("3").multiverseId(3).name("deck 3").text("hello world").build());
        mtgDeck.setDeck(cards);
        mtgDeck.setName("Deck 1");
        return args -> {
            /*
            cardRepository.save(
                    MtgCard.builder().manaCost("3").multiverseId(1234).name("test 1").text("hello").build()
            );
            cardRepository.save(
                    MtgCard.builder().manaCost("2").multiverseId(5678).name("test 2").text("world").build()
            );

             */
            deckRepository.save(mtgDeck);
        };
    }

}
