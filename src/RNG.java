import java.util.Random;

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

    public int generateNumber(int minimumValue, int maximumValue)
    {
        Random random = new Random();
        int randomNumber = minimumValue + random.nextInt(maximumValue);//generate a number from 1 to rangeLimit
        return randomNumber;
    }
}
