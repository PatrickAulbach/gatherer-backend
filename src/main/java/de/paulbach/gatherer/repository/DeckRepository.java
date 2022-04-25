package de.paulbach.gatherer.repository;


import de.paulbach.gatherer.model.MtgDeck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<MtgDeck, String> {
}
