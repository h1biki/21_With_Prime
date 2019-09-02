

public class Tile
{
    private int value;
    private int score;

    public Tile()
    {
        value = 0;
        score = 0;
    }

    public Tile(int newValue, int newScore)
    {
        value = newValue;
        score = newScore;
    }


    public int getScore()
    {
        return score;
    }

    public int getValue()
    {
        return value;
    }

    public void setScore(int newScore)
    {
        score = newScore;
    }

    public void setValue(int newValue)
    {
        value = newValue;
    }

}
