
public class Card {
    
    //created using top-down
    //first two values null so array slots represent their literal values (example: array slot 2 maps to rank 2, 9 maps to 9)
    public static final String[] RANKS = {null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private int rank; //2-14
    private int suit; //0-3
    
    
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    
    //1 if card has greater rank than compared to card, -1 if lesser, 0 if equal
    public int compareTo(Card that) {
        if(this.rank > that.rank) {
            return 1;
        }
        if(this.rank < that.rank) {
            return -1;
        }
        return 0;
    }
    
    
    //getters, no setters because no need to change cards' values once declared
    public int getRank() {
        return this.rank;
    }
    public int getSuit() {
        return this.suit;
    }
    
    
    //override toString to return in format of "Ace of Spades"
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit]; 
    }
}
