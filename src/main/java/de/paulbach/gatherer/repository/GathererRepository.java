package de.paulbach.gatherer.repository;

import de.paulbach.gatherer.model.MtgCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GathererRepository extends JpaRepository<MtgCard, Long> {

}
