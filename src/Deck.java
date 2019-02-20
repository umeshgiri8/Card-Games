/**
 * Created by Admin on 7/29/2017.
 */
import java.util.Random;

public class Deck {

    Random random = new Random();

    private Integer [][][] Deck;
    private Boolean SuffledRecord [][][];
    private Integer NoOfDeck;
    private Integer DrawnDeck;
    private Integer DrawnCard;



    public Deck(Integer NoOfDeck){

        this.NoOfDeck = NoOfDeck;
        Deck = new Integer[NoOfDeck][52][2];
        SuffledRecord = new Boolean[NoOfDeck][4][13];
        for(int count1=0;count1<NoOfDeck;count1++)
        {
            for(int count2=0;count2<4;count2++)
            {
                for(int count3=0;count3<13;count3++)
                {
                    SuffledRecord[count1][count2][count3] = false;
                }
            }
        }
    }

    public Deck()
    {
        this.NoOfDeck = 1;
        Deck = new Integer[NoOfDeck][52][2];
        SuffledRecord = new Boolean[NoOfDeck][4][13];

        for(int count1=0;count1<NoOfDeck;count1++)
        {
            for(int count2=0;count2<4;count2++)
            {
                for(int count3=0;count3<13;count3++)
                {

                    SuffledRecord[count1][count2][count3] = false;
                }
            }
        }
    }

    public void Suffle()
    {
        int sDeck,sSuit,sCard,cardcount;
        DrawnDeck=0;
        DrawnCard=-1;
        for(int count1=0; count1<NoOfDeck; count1++)
        {
            cardcount=0;
            for(int count2=0; count2<4; count2++)
            {
                for(int count3=0; count3<13; count3++)
                {
                    if(NoOfDeck==1)
                    {
                        sDeck = 0;
                    }
                    else{
                    sDeck = random.nextInt((NoOfDeck-1));
                    }
                    sSuit = random.nextInt(4);
                    sCard = random.nextInt(13);


                    if(SuffledRecord[sDeck][sSuit][sCard])
                    {
                        count3--;
                    }
                    else{

                        Deck[sDeck][cardcount][0] = sCard;
                        Deck[sDeck][cardcount][1] = sSuit;
                        SuffledRecord[sDeck][sSuit][sCard] = true;
                        cardcount++;
                    }
                }
            }
        }
    }

    public Integer[] DrawCard()
    {

        DrawnCard++;

        if(DrawnCard>51)
        {
            DrawnDeck++;
            DrawnCard=0;
        }

        return  Deck[DrawnDeck][DrawnCard];
    }

    public String getCardName(Integer[]Card) {

    String Name;

        switch (Card[0]) {
            case 0:
                Name = "Ace";
            break;

            case 10:
                Name = "Jack";
            break;

            case 11:
                Name = "Queen";
            break;

            case 12:
                Name = "King";
            break;

            default:
                Name = ""+(Card[0]+1);
        }
        
         
        switch (Card[1])
        {
            case 0:
                Name = Name +  " of Spade";
                break;

            case 1:
                Name = Name +  " of Clubs";
                break;

            case 2:
                Name = Name +  " of Diamonds";
                break;

            case 3:
                Name = Name +  " of Hearts";
        }

        return Name;
    }


    public Integer getNoOfDeck()
    {
        return this.NoOfDeck;
    }
}
