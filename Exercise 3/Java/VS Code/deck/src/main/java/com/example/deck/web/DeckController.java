import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/")
    public String viewDeck(Model model) {
        model.addAttribute("cards", deckService.getDeck());
        return "deck";
    }

    @PostMapping("/shuffle")
    public String shuffleDeck(Model model) {
        model.addAttribute("cards", deckService.shuffle());
        return "deck";
    }
}
