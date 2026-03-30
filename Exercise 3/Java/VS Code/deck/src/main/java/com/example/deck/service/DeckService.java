import org.springframework.stereotype.Service;

@Service
public class DeckService {

    private final Deck deck = new Deck();

    public List<Card> getDeck() {
        return deck.getCards();
    }

    public List<Card> shuffle() {
        deck.shuffle();
        return deck.getCards();
    }
}
