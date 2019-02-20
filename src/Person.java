import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * Created by Admin on 7/30/2017.
 */
public class Person {

    private String Name;
    private Integer [][] Hand;
    private Integer [] Record = {0,0};
    private Integer NoOfCards;

        public Person(String Name,Integer NoOfCards)
        {
            this.Name = Name;
            this.NoOfCards = NoOfCards;
            Hand = new Integer[NoOfCards][2];
        }

        public String getName()
        {
            return this.Name;
        }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCard(Integer location) {
        return Hand[location][0];
    }

    public Integer getSuit(Integer Location)
    {
        return Hand[Location][1];
    }

    public Integer [] getCardAndSuit(Integer Location)
    {
        return Hand[Location];
    }

    public void setCard(Integer[] hand,Integer CardNo) {
        Hand[CardNo] = hand;
    }

    public void sortCard()
    {


        Integer [] CardArray = new Integer[NoOfCards];
        Integer [] SuitArray = new Integer[NoOfCards];


        for(int count1=0;count1<NoOfCards;count1++)
        {
            CardArray[count1] = Hand[count1][0];
        }

        Arrays.sort(CardArray);

        for(int count1=0;count1<NoOfCards;count1++)
        {
            for(int position=0;position<NoOfCards;position++)
            {
                if(CardArray[count1] == Hand[position][0])
                {
                    SuitArray[count1] = Hand[position][1];
                    Hand[position][0] = -1;
                    break;
                }
            }
        }

        for(int count1=0;count1<NoOfCards;count1++)
        {
            Hand[count1][0] = CardArray[count1];
            Hand[count1][1] = SuitArray[count1];
        }


    }


    public void updateRecord(Boolean Rec)
    {
        if(Rec)
        {
            Record[1]++;
        }
        Record[0]++;
    }

    public Integer getTimesPlayed()
    {
        return Record[0];
    }

    public Integer getTimesWon()
    {
        return Record[1];
    }















}
