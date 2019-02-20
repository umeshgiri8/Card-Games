/**
 * Created by Admin on 7/31/2017.
 */

import java.util.Scanner;
public class Main {

    private static Person [] P;
    private static Integer NoOfPlayers;
    private static Boolean NOTVALID=true;
    private static Scanner S = new Scanner(System.in);

    public static void main(String[] args) {


        Integer SelectedGame=0;
        Boolean REPEAT=true;
        String [] Games = {"Teen patti"};


        System.out.println("Welcome to Card Games: ");



        while(REPEAT) {
            System.out.println("We have following Games:- ");

            for (int count1 = 0; count1 < Games.length; count1++) {
                System.out.println(count1 + 1 + ". " + Games[count1]);
            }

            NOTVALID=true;
            while(NOTVALID) {
                System.out.print("\nEnter the no. of game you want to play: ");
                SelectedGame = S.nextInt();

                if (SelectedGame > Games.length || SelectedGame <= 0) {

                    NOTVALID = true;
                }
                else{
                    NOTVALID=false;
                }
            }


            switch(SelectedGame)
            {
                case 1:
                    teenpattiplay();
                    break;

            }

            System.out.println("\n\nDo you want to play again? \n 1 for yes and any thing for NO");
            if(S.nextInt() == 1)
            {
                REPEAT = true;
            }
            else{
                REPEAT = false;
            }

        }


    }



    private static void teenpattiplay()
    {
        NOTVALID=true;
        while(NOTVALID) {
            System.out.print("Enter the no. of players (including you) : ");
            NoOfPlayers = S.nextInt();

            if (NoOfPlayers < 18 && NoOfPlayers > 0) {
                NOTVALID = false;
            }
            else{
                NOTVALID=true;
            }
        }

        System.out.println("\n\n");
        TeenPatti t = new TeenPatti(NoOfPlayers);
        P = new Person[NoOfPlayers];

        t.Suffle();

        for(int count1=0;count1<NoOfPlayers;count1++)
        {
            P[count1] = new Person("Player " + (count1+1),3);
            for(int count2=0; count2<3;count2++) {
                P[count1].setCard(t.DrawCard(),count2);
            }
            P[count1].sortCard();
            System.out.println(P[count1].getName());
            t.toString(P[count1]);
            System.out.println("");
        }



        if(!t.checkTrio(P)) {
            if (!t.checkDoubleRun(P)) {
                if (!t.checkRun(P)) {
                    if (!t.checkColor(P)) {
                        if (!t.checkTwin(P)) {
                            t.checkTop(P);
                        }
                    }
                }
            }
        }
        t.calculateWinner();
        t.announceWinner(P);
        t.updateRecord(P);
        t.getStats(P);
        //t.remarks(P);
        System.out.println("Times played teen patti "+ t.getTimesPlayedTeenPatti());
    }
}
