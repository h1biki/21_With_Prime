/**
 * class Tile is the tiles which players played, with attributes value and score
 *
 * @author (Zixi Zhao)
 * @version (10-9-2019)
 */

public class Tile
{
    private int value;
    private int score;
    /**
     * Default constructor for objects of class Tile
     */
    public Tile()
    {
        value = 0;
        score = 0;
    }

    /**
     * Non-default constructor for objects of class Tile
     */
    public Tile(int newValue, int newScore)
    {
        value = newValue;
        score = newScore;
    }

    /**
     * Accessor of score
     *
     * @return    score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Accessor of value
     *
     * @return    value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Mutator of score
     *
     * @param  int newScore
     * @return    void
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }

    /**
     * Mutator of value
     *
     * @param  int newValue
     * @return    void
     */
    public void setValue(int newValue)
    {
        value = newValue;
    }

}
