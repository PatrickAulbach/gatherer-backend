package de.paulbach.gatherer.resource;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.MtgDeck;
import de.paulbach.gatherer.model.Response;
import de.paulbach.gatherer.service.implementation.GathererServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*") // for now
public class GathererResource {

    private final GathererServiceImpl gathererService;

    @PostMapping("addCard/{name}")
    public ResponseEntity<Response> addCard(@PathVariable("name") String name) {
        MtgCard card = gathererService.add(name);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Card added")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("Card", card))
                        .build()
        );

    }

    @GetMapping("getCard/{id}")
    public ResponseEntity<Response> getCard(@PathVariable("id") Long id) {
        MtgCard card = gathererService.get(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Card read")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("Card", card))
                        .build()
        );
    }

    @GetMapping("getDeck/{name}")
    public ResponseEntity<Response> getDeck(@PathVariable("name") String name) {
        MtgDeck deck = gathererService.getDeck(name);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Deck read")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("Deck", deck.getDeck(), "Name", deck.getName()))
                        .build()
        );
    }

}
