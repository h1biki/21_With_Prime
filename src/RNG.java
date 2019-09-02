import java.util.*;

public class RNG
{
    private int maximumValue;
    private int minimumValue;

    public RNG()
    {
        int maximumValue = 0;
        int minimumValue = 0;
    }

    public RNG(int newMaximumValue, int newMinimumValue)
    {
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
    }

    public int getMaximumValue()
    {
        return maximumValue;
    }

    public int getMinimumValue()
    {
        return minimumValue;
    }

    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }

    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }

    public int generateNumber(int rangeLimit)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(rangeLimit + 1);//genarate a number from 1 to rangeLimit
        return randomNumber;
    }
}
