package de.paulbach.gatherer.controller;

import de.paulbach.gatherer.model.MtgDeck;
import de.paulbach.gatherer.model.Response;
import de.paulbach.gatherer.service.DeckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DeckController {

    @Autowired
    DeckService deckService;

    @GetMapping("getDeck/{name}")
    public ResponseEntity<Response> getDeck(@PathVariable("name") String name) {
        MtgDeck deck = deckService.getDeck(name);
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
