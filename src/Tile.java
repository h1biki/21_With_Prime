/**
 * class Tile is the tiles which players played, with attributes value and score
 *
 * @author (Zixi Zhao)
 * @version (14-9-2019)
 */
public class Tile
{
    private int value;//the value of a tile
    private int score;//the score of a tile

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
     * @param  newScore the new value of score
     * @return    void
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }

    /**
     * Mutator of value
     *
     * @param  newValue the new value of score
     * @return    void
     */
    public void setValue(int newValue)
    {
        value = newValue;
    }
}
