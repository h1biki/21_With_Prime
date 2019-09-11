/**
 * class RNG is the random number generator
 *
 * @author (Zixi Zhao)
 * @version (10-9-2019)
 */

import java.util.Random;

public class RNG
{
    private int maximumValue;
    private int minimumValue;
    /**
     * Default constructor for objects of class RNG
     */
    public RNG ()
    {
        maximumValue = 0;
        minimumValue = 0;
    }

    /**
     * Non-default constructor for objects of class RNG
     */
    public RNG (int newMinimumValue, int newMaximumValue)
    {
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
    }

    /**
     * Accessor of maximumValue
     *
     * @return    maximumValue
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }

    /**
     * Accessor of minimumValue
     *
     * @return    minimumValue
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }

    /**
     * Mutator of maximumValue
     *
     * @param  int newMaximumValue
     * @return    void
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }

    /**
     * Mutator of minimumValue
     *
     * @param  int newMinimumValue
     * @return    void
     */
    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }

    /**
     * To genarate a random number, inclusive range from minimumValue to maximumValue
     *
     * @return    an integer random number
     */
    public int generateNumber()
    {
        Random random = new Random();
        int randomNumber = minimumValue + random.nextInt(maximumValue - minimumValue + 1);
        return randomNumber;
    }
}
