import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Spielkarte {
    private String value;
    private String color;

    public void setValue(String value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Spielkarte{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public Spielkarte(String value, String color) {
        this.value = value;
        this.color = color;
    }
}

class Deck {
    private final List<Spielkarte> listOfKarten;

    public Deck(List<Spielkarte> listOfKarten) {
        this.listOfKarten = listOfKarten;
    }

    public void add(Spielkarte karte) {
        listOfKarten.add(karte);
    }

    public List<Spielkarte> getListOfKarten() {
        return listOfKarten;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "listOfKarten=" + listOfKarten +
                '}';
    }
}

class DeckIterator implements Iterator<Spielkarte> {

    private int index;
    private final Deck deck;

    DeckIterator(int index, Deck deck) {
        this.index = index;
        this.deck = deck;
    }

    @Override
    public boolean hasNext() {
        return index < deck.getListOfKarten().size();
    }

    @Override
    public Spielkarte next() {
        if (hasNext()) {
            index++;
            return deck.getListOfKarten().get(index);
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Spielkarte> listOfCards = new ArrayList<Spielkarte>();
        listOfCards.add(new Spielkarte("5", "rosu"));
        listOfCards.add(new Spielkarte("5", "negru"));
        listOfCards.add(new Spielkarte("9", "rosu"));


        Deck deck = new Deck(listOfCards);
//        System.out.println(deck.getListOfKarten().size());
//        System.out.println(deck);

        for (Spielkarte spielkarte : deck){
            System.out.println(spielkarte);
        }
    }
}