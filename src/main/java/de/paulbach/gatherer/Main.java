package de.paulbach.gatherer;

import de.paulbach.gatherer.model.MtgCard;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Card> cards = CardAPI.getAllCards(List.of("name=Meathook"));

        System.out.println(cards.size());
        cards = cards.stream().filter(card -> card.getMultiverseid() != -1).collect(Collectors.toList());
        for (Card card : cards) {
            System.out.println(card.getName());
            System.out.println(card.getMultiverseid());
            System.out.println(card.getImageUrl());
            System.out.println("###");
        }
        MtgCard mtgCard = new MtgCard();
        mtgCard.setName(cards.get(0).getName());
        mtgCard.setManaCost(cards.get(0).getManaCost());
        mtgCard.setText(cards.get(0).getOriginalText());
        mtgCard.setMultiverseId(cards.get(0).getMultiverseid());
    }
}
