/**
 * Created by Admin on 7/31/2017.
 */
public class TeenPatti extends Game{

    private static Integer timesPlayedTeenPatti=0;

    public TeenPatti(Integer NumberOfPlayers)
    {
        super(1,NumberOfPlayers);
        timesPlayedTeenPatti++;
    }

    public Integer getTimesPlayedTeenPatti() {
        return timesPlayedTeenPatti;
    }
}
