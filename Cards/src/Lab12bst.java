// Lab12bvst.java     This is the Student-Starting file. 
// This version is implemented with "Dynamic Arrays"
// This assignment pertains to some of the "Elevens" AP Lab Materials
//***************************************************************************
// The "Elevens" AP Lab is created for the College Board APCS
// curriculum by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Leon Schram has altered some of the "Elevens" files to focus on 
// specific CS topics as the "Elevens" Lab is integrated into the curriculum.



import java.util.ArrayList;
import java.util.Random;

public class Lab12bst
{
	public static void main(String[] args)
	{   
      Deck deck = new Deck();
      System.out.println(deck.Shuffle());
	}
}


class Deck
{
	private ArrayList<Card> cards;
	private int size;
String Suits[] = {"Clubs","Diamonds","Hearts","Spades"};
String Rank[] = {"Ace","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","King","Jack","Queen"};
Random r = new Random();
	public Deck() 
   {
      size = 52;
      cards = new ArrayList<Card>();  
      MakeCards();
   }
        public ArrayList MakeCards(){
        for(int i =0;i < Suits.length;i++){
          for(int j = 0; j <= 13;j++){
      cards.add(new Card(Suits[i],Rank[j],ArrValues(j)));
            }
          }
            return cards;
        }
        public void add(String suit, String rank, int value)
   {
      Card temp = new Card(suit,rank,value);
      cards.add(temp);
      size++;
   }
        public int ArrValues(int j){
        int temp = j;
            if(Rank[j].equals("King") || Rank[j].equals("Queen") || Rank[j].equals("Jack")){
        temp = 10;
        } else if (Rank[j].equals("Ace")){
        temp = 11;
        }
            return temp;
        }
        public ArrayList Shuffle(){
           
        for(int i =0;i < cards.size();i++){
        int r1 = r.nextInt(size);
        int r2 = r.nextInt(size);     
        if(r1 != r2){
        cards.add(r1,cards.get(r2));
        }
            if(r1 < r2){
            cards.remove(cards.get(r2+1));
            }
        }
         
        return cards;
        }
    public String toString()
   {
      String temp = "";
      for (int k = 0; k < size; k++)
         temp = temp + cards.get(k).toString() + "\n";
      //return temp
      return cards.toString();   
   }
 }