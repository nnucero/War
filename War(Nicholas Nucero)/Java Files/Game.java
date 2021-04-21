import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//War card game by Nicholas Nucero for Deacom Inc. Software Development Internship Interview
//Created: 4/13/2021

public class Game {
    public static void main(String[] args) {
        
        //remove comment at end where specified to change program to turn-by-turn mode.
        
        //create a deck of cards using an ArrayList
        ArrayList<Card> cards = new ArrayList<Card>();
        int turns = 0;
        
        for(int s = 0; s <= 3; s++) {
            for(int r = 2; r <= 14; r++) {      //2-14 because first 2 values are null
                cards.add(new Card(r, s));
            }
        }

        //shuffle
        for(int i = 0; i < 1000; i++) {
            Collections.swap(cards, randomInt(0, cards.size() - 1), randomInt(0, cards.size() - 1));
        }

        //deal deck to players
        ArrayList<Card> playerOne = new ArrayList<Card>();
        ArrayList<Card> playerTwo = new ArrayList<Card>();
        for(int i = 0; i < 26; i++) {
            playerOne.add(cards.get(i));
        }
        for(int i = 26; i < 52; i++) {
            playerTwo.add(cards.get(i));
        }

        //play game
        while((playerOne.size() > 0) && (playerTwo.size() > 0)) {
            turns++;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Player 1 deck count = " + playerOne.size());
            System.out.println("Player 2 deck count = " + playerTwo.size());
            System.out.println("");
            
            for(int i = 0; i < 1000; i++) {
                Collections.swap(playerOne, randomInt(0, playerOne.size() - 1), randomInt(0, playerOne.size() - 1));
            }
            for(int i = 0; i < 1000; i++) {
                Collections.swap(playerTwo, randomInt(0, playerTwo.size() - 1), randomInt(0, playerTwo.size() - 1));
            }
            
            int result = playerOne.get((playerOne.size() - 1)).compareTo(playerTwo.get(playerTwo.size() - 1));
            int warResult;

            System.out.println("Player 1 draws a(n) " + playerOne.get(playerOne.size() - 1));
            System.out.println("Player 2 draws a(n) " + playerTwo.get(playerTwo.size() - 1));

            if(result == 1) {   //player 1 wins
                System.out.println("Player 1 wins, he gets: " + playerTwo.get(playerTwo.size() - 1));
                
                playerOne.add(playerTwo.get(playerTwo.size() - 1));
                playerTwo.remove(playerTwo.size() - 1);
            }

            if(result == -1) {  //player 2 wins
                System.out.println("Player 2 wins, he gets: " + playerOne.get(playerOne.size() - 1));
                
                playerTwo.add(playerOne.get(playerOne.size() - 1));
                playerOne.remove(playerOne.size() - 1);
            }

            if(result == 0) {   //it's a tie, war begins
                System.out.println("It's a tie, press Enter to continue");
                

                System.out.println("Player 1 draws a(n) " + playerOne.get(playerOne.size() - 2) + " as his face-up card.");
                System.out.println("Player 2 draws a(n) " + playerTwo.get(playerTwo.size() - 2) + " as his face-up card.");

                warResult = playerOne.get((playerOne.size() - 2)).compareTo(playerTwo.get(playerTwo.size() - 2));

                if(warResult == 1) {
                    System.out.println("Player 1 wins, he gets: " + playerTwo.get(playerTwo.size() - 1) + ", " + playerTwo.get(playerTwo.size() - 2) + ", " + playerTwo.get(playerTwo.size() - 3));
                    
                    playerOne.add(playerTwo.get(playerTwo.size() - 1));
                    playerOne.add(playerTwo.get(playerTwo.size() - 2));
                    playerOne.add(playerTwo.get(playerTwo.size() - 3));
                    playerTwo.remove(playerTwo.size() - 1);
                    playerTwo.remove(playerTwo.size() - 1);
                    playerTwo.remove(playerTwo.size() - 1);
                }
                if(warResult == -1) {
                    System.out.println("Player 2 wins, he gets: " + playerOne.get(playerOne.size() - 1) + ", " + playerOne.get(playerOne.size() - 2) + ", " + playerOne.get(playerOne.size() - 3));
                    
                    playerTwo.add(playerOne.get(playerOne.size() - 1));
                    playerTwo.add(playerOne.get(playerOne.size() - 2));
                    playerTwo.add(playerOne.get(playerOne.size() - 3));
                    playerOne.remove(playerOne.size() - 1);
                    playerOne.remove(playerOne.size() - 1);
                    playerOne.remove(playerOne.size() - 1);
                }
                if(warResult == 0) {
                    System.out.println("It's a tie, press Enter to continue");
                    

                    System.out.println("Player 1 flips his face-down card. It is a(n) " + playerOne.get(playerOne.size() - 3));
                    System.out.println("Player 2 flips his face-down card. It is a(n) " + playerTwo.get(playerTwo.size() - 3));

                    warResult = playerOne.get((playerOne.size() - 3)).compareTo(playerTwo.get(playerTwo.size() - 3));

                    if(warResult == 1) {
                        System.out.println("Player 1 wins, he gets: " + playerTwo.get(playerTwo.size() - 1) + ", " + playerTwo.get(playerTwo.size() - 2) + ", " + playerTwo.get(playerTwo.size() - 3));
                        
                        playerOne.add(playerTwo.get(playerTwo.size() - 1));
                        playerOne.add(playerTwo.get(playerTwo.size() - 2));
                        playerOne.add(playerTwo.get(playerTwo.size() - 3));
                        playerTwo.remove(playerTwo.size() - 1);
                        playerTwo.remove(playerTwo.size() - 1);
                        playerTwo.remove(playerTwo.size() - 1);
                    }
                    if(warResult == -1) {
                        System.out.println("Player 2 wins, he gets: " + playerOne.get(playerOne.size() - 1) + ", " + playerOne.get(playerOne.size() - 2) + ", " + playerOne.get(playerOne.size() - 3));
                        
                        playerTwo.add(playerOne.get(playerOne.size() - 1));
                        playerTwo.add(playerOne.get(playerOne.size() - 2));
                        playerTwo.add(playerOne.get(playerOne.size() - 3));
                        playerOne.remove(playerOne.size() - 1);
                        playerOne.remove(playerOne.size() - 1);
                        playerOne.remove(playerOne.size() - 1);
                    }
                    if(warResult == 0) { //very rare, (1/14)^3 or 1/2744 chance of occurring, so call a tie at this point for the current hand 
                        System.out.println("It's a tie, both teams keep their cards, press Enter to continue");
                    }
                }
            }
            
            //remove comments on below 3 lines to make program step through turn by turn

            //System.out.println("Press Enter to continue");
            //try{System.in.read();}
            //catch(Exception e){}
        }
        if(playerTwo.size() == 0) {
            System.out.println("Player One Wins!");
        }
        if(playerOne.size() == 0) {
            System.out.println("Player Two Wins!");
        }
        System.out.println("This result took " + turns + " turns.");
        
        System.out.println("Press Enter to end the game.");
        try{System.in.read();}
        catch(Exception e){}
    }

    public static int randomInt(int low, int high) {
        Random rand = new Random();
        int randomValue = rand.nextInt(high - low + 1) + low;
        return randomValue;
    }
}
