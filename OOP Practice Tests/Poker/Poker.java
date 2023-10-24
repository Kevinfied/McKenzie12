import java.util.*;

public class Poker{

    public static void main(String[] args) {
		Deck deck = new Deck();
		for(int i=1; i<=10; i++){					
			ArrayList<Card>player = deck.deal(3);
			ArrayList<Card>computer = deck.deal(3);
			
			System.out.println("\nGame "+i+":");
			System.out.println("------------");
			System.out.println("Player has: " + player);
			showHand(player);
			System.out.println("Computer has: " + computer);
			showHand(computer);
			
			if(evaluateHand(computer) > evaluateHand(player)){
				System.out.println("Computer Wins!");
			}
			else if(evaluateHand(player) > evaluateHand(computer)){
				System.out.println("Player Wins!");
			}
			else{
				System.out.println("Its a tie.");
			}
		}
		
    }

	public static boolean threeKind(ArrayList<Card>hand){
		return hand.get(0).getVal() == hand.get(1).getVal()  && hand.get(1).getVal() == hand.get(2).getVal();	
	}

	public static void showHand(ArrayList<Card>hand){
		String []hands={"High Card","Pair","Flush","Straight","Three of a kind","Straight Flush"};
		System.out.println(hands[evaluateHand(hand)]);
	}

    public static boolean pair(ArrayList<Card>hand) {

        return hand.get(0).getVal() == hand.get(1).getVal() || hand.get(1).getVal() == hand.get(2).getVal() || hand.get(0).getVal() == hand.get(2).getVal();
    }

    public static boolean straight(ArrayList<Card>hand) {

        int[] vals = new int[3];
        for (int i = 0; i < 3; i++) {
            vals[i] = hand.get(i).getVal();
        }
        Arrays.sort(vals);
        return vals[0] + 1 == vals[1] && vals[1] + 1 == vals[2];
        // return hand.get(0).getVal() + 1 == hand.get(1).getVal() && hand.get(1).getVal() + 1 == hand.get(2).getVal();
    }


    public static boolean flush(ArrayList<Card>hand) {

        return hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit();

    }

    public static boolean straightFlush(ArrayList<Card>hand) {

        return straight(hand) && flush(hand);

    }

	public static int evaluateHand(ArrayList<Card>hand){
		if(threeKind(hand)){
			return 4;
		}
        else if (straightFlush(hand)) {
            return 5;
        }
        else if (flush(hand)) {
            return 2;
        }
        else if (straight(hand)) {
            return 3;
        }
        else if (pair(hand)) {
            return 1;
        }
		else{
			return 0;
		}		
	}

}

class Deck{
	private ArrayList<Card>cards;
	
	public Deck(){
		init();
	}

	public void init(){
		cards = new ArrayList<Card>();
		for(int i = 0; i<52; i++){
			cards.add(new Card(i));
		}
		Collections.shuffle(cards);	
	}

	public ArrayList<Card>deal(int n){
		if(n>cards.size()){
			init();
		}
		ArrayList<Card>ans = new ArrayList<Card>(cards.subList(0,n));
		cards.removeAll(ans);
		return ans;
	}
}

class Card{
	private int val, suit;
	
	public Card(int n){
		val = n%13+1;
		suit = n/13;
	}
	
	public int getVal(){
		return val;
	}
	public int getSuit(){
		return suit;
	}


    @Override
    public String toString() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] vals = {"Ace", 
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
                         "Jack", "Queen", "King"};

        return vals[val-1] + " of " + suits[suit];

    }
	
}
