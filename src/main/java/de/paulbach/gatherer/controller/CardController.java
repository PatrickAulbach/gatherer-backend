package de.paulbach.gatherer.controller;

import de.paulbach.gatherer.model.MtgCard;
import de.paulbach.gatherer.model.Response;
import de.paulbach.gatherer.service.CardService;
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
public class CardController {

    @Autowired
    private final CardService cardService;

    @PostMapping("addCard")
    public ResponseEntity<Response> addCard(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "quantity", required = false) int quantity) {
        MtgCard card = cardService.addCard(name, quantity);
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
        MtgCard card = cardService.getCard(id);
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

}
