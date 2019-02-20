import java.util.Arrays;

/**
 * Created by Admin on 7/29/2017.
 */


public class Game extends Deck{

    private Integer NoOfWinners,NoOfPlayers;
    private Integer [] PlayerPriority, WinnersNo;
    private String WinnerField;
    private static Integer TimesPlayed=0;


    public Game(Integer NoOfDeck,Integer NoOfPlayers)
    {
        super(NoOfDeck);
        this.NoOfPlayers = NoOfPlayers;
        PlayerPriority = new Integer[NoOfPlayers];
        WinnersNo = new Integer[NoOfPlayers];
        NoOfWinners = 0;
        TimesPlayed++;
    }


    public Game()
    {
        super(1);
        this.NoOfPlayers = 1;
        PlayerPriority = new Integer[this.NoOfPlayers];
        WinnersNo = new Integer[this.NoOfPlayers];
        NoOfWinners = 0;
        TimesPlayed++;
    }

    public Boolean checkTrio(Person [] P)
    {
        Boolean exists = false;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            if((P[count1].getCard(0) == P[count1].getCard(1)) && (P[count1].getCard(0) == P[count1].getCard(2)) )
            {
                exists = true;
                WinnerField = "Trio";
                PlayerPriority[count1] = P[count1].getCard(0);
            }
            else {
                PlayerPriority[count1] = 0;
            }
        }
        return exists;
    }


    public Boolean checkDoubleRun(Person [] P)
    {
        Boolean exists = false;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            if((P[count1].getSuit(0) == P[count1].getSuit(1)) && (P[count1].getSuit(0) == P[count1].getSuit(2)) )
            {

                if(P[count1].getCard(0) == 0 ) {
                    if (P[count1].getCard(1) == 1 && P[count1].getCard(2) == 2)
                    {

                        exists = true;
                        WinnerField = "DoubleRun";
                        PlayerPriority[count1]=35;
                    }

                    else if(P[count1].getCard(1)==11 && P[count1].getCard(2)==12 )
                    {

                        exists = true;
                        WinnerField = "DoubleRun";
                        PlayerPriority[count1]=34;
                    }
                }

                else if (((P[count1].getCard(0) + 1) == P[count1].getCard(1)) && ((P[count1].getCard(1) + 1) == P[count1].getCard(2)))
                {
                    exists = true;
                    WinnerField = "DoubleRun";
                    PlayerPriority[count1] = P[count1].getCard(0) + P[count1].getCard(1) + P[count1].getCard(2);
                }

            }

            else {
                PlayerPriority[count1] = 0;
            }
        }

        return exists;
    }



    public Boolean checkRun(Person [] P)
    {

        Boolean exists = false;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {

                if(P[count1].getCard(0) == 0 ) {
                    if (P[count1].getCard(1) == 1 && P[count1].getCard(2) == 2)
                    {

                        exists = true;
                        WinnerField = "Run";
                        PlayerPriority[count1]=35;
                    }

                    else if(P[count1].getCard(1)==11 && P[count1].getCard(2)==12 )
                    {

                        exists = true;
                        WinnerField = "Run";
                        PlayerPriority[count1]=34;
                    }
                }

                else if (((P[count1].getCard(0) + 1) == P[count1].getCard(1)) && ((P[count1].getCard(1) + 1) == P[count1].getCard(2)))
                {
                    exists = true;
                    WinnerField = "Run";
                    PlayerPriority[count1] = P[count1].getCard(0) + P[count1].getCard(1) + P[count1].getCard(2);
                }

                else {
                    PlayerPriority[count1] = 0;
                }
        }

        return exists;
    }


    public Boolean checkColor(Person [] P)
    {

        Boolean exists = false;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            PlayerPriority[count1] = 0;
            if((P[count1].getSuit(0) == P[count1].getSuit(1)) && (P[count1].getSuit(0) == P[count1].getSuit(2)) )
            {
                exists = true;
                WinnerField = "color";

                if(P[count1].getCard(0) == 0)
                {
                    PlayerPriority[count1] = 13 * 100;
                }

                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(2)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(1)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(0)) * 100;
            }

            else {
                PlayerPriority[count1] = 0;
            }
        }

        return exists;
    }



    public Boolean checkTwin (Person [] P)
    {

        Boolean exists = false;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            PlayerPriority[count1]=0;
            if((P[count1].getCard(0) == P[count1].getCard(1)) || (P[count1].getCard(1) == P[count1].getCard(2)) ) {
                exists = true;
                WinnerField = "Twin";

                if((P[count1].getCard(0)==0 && P[count1].getCard(1) ==0))
                {
                    PlayerPriority[count1] = 13 * 100;
                }

                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(2)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(1)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(0)) * 100;
            }


            else {
                PlayerPriority[count1] = 0;
            }
        }

        return exists;
    }


    public void checkTop (Person [] P)
    {

        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            PlayerPriority[count1]=0;
                WinnerField = "Top";

                if(P[count1].getCard(0)==0 )
                {
                    PlayerPriority[count1] = 13 * 100;
                }

                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(2)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(1)) * 100;
                PlayerPriority[count1] = (PlayerPriority[count1] + P[count1].getCard(0)) * 100;

        }


    }

    public void calculateWinner()
    {
        int greatest  = 0;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            if(greatest<PlayerPriority[count1])
            {
                greatest = PlayerPriority[count1];
                NoOfWinners=1;
                WinnersNo[NoOfWinners-1] = count1;
            }

            else if(greatest == PlayerPriority[count1])
            {
                NoOfWinners++;
                WinnersNo[NoOfWinners-1] = count1;
            }
        }
    }

    public void announceWinner(Person [] P)
    {
        System.out.print("Winner");
        if(NoOfWinners>1)
        {
            System.out.print("s");
        }

        System.out.print(" from " + WinnerField );

        if(NoOfWinners>1)
        {
            System.out.print(" are :");
        }
        else{
            System.out.print(" is : ");
        }

        for(int count1=0;count1<NoOfWinners;count1++)
        {
            System.out.println(P[WinnersNo[count1]].getName());
        }
    }

    public void updateRecord(Person [] P)
    {

        int count2;
        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            for(count2=0;count2<NoOfWinners;count2++)
            {
                if(count1 == WinnersNo[count2])
                {
                    P[count1].updateRecord(true);
                    count2 = NoOfWinners + 2;
                    break;
                }
            }

            if(count2<=NoOfWinners)
            {
                P[count1].updateRecord(false);
            }
        }
    }



    public void toString(Person P)
    {
        for(int count1=0;count1<3;count1++)
        System.out.println(getCardName(P.getCardAndSuit(count1)));
    }


    public void getStats(Person [] P)
    {
        System.out.println("Times Played: "+getTimesPlayed());
    }
    public Integer getTimesPlayed()
    {
        return TimesPlayed;
    }

    public Integer getNoOfPlayers() {
        return NoOfPlayers;
    }

    public void setNoOfPlayers(Integer noOfPlayers) {
        NoOfPlayers = noOfPlayers;
    }


}
