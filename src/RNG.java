import java.util.Random;

public class RNG {
    private int maximumValue;
    private int minimumValue;

    public RNG (int newMinimumValue, int newMaximumValue)
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

    public int generateNumber()
    {
        Random random = new Random();
        int randomNumber = minimumValue + random.nextInt(maximumValue - minimumValue + 1);
        return randomNumber;
    }
}
