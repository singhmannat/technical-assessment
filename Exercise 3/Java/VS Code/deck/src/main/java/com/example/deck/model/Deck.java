import java.util.*;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                String label = rank.label + " of " + suit.name();
                String imagePath = "/cards/" + suit.name() + "_" + rank.name() + ".png";
                cards.add(new Card(suit, rank, label, imagePath));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }
}
