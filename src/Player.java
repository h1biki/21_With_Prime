

public class Player
{
    private String name;
    private int score;
    private int roundsWon;
    private Tile tiles[];
    private Tile lastTilePlayed;
    //private int totalScore;
    public Player()
    {
        name = "";
        score = 0;
        roundsWon = 0;
        tiles = new Tile[5];
        lastTilePlayed = new Tile();
        //totalScore = 0;
    }

    public Player(String newName, int newScore, Tile[] newTiles, Tile newLastTilePlayed, int newRoundsWon, int newTotalScore)
    {
        name = newName;
        score = newScore;
        tiles = newTiles;
        lastTilePlayed = newLastTilePlayed;
        roundsWon = newRoundsWon;
        //totalScore = newTotalScore;
    }

    public void setTiles(Tile newTiles[])
    {
        tiles = newTiles;
    }

    public Tile[] getTiles()
    {
        return tiles;
    }

    public int getRoundsWon()
    {
        return roundsWon;
    }

   /*public int getTotalScore()
   {
       return totalScore;
   }

   public void setTotalScore(int newTotalScore)
   {
       totalScore = newTotalScore;
   }
   */

    public void setRoundsWon(int newRoundsWon)
    {
        roundsWon = newRoundsWon;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int newScore)
    {
        score = newScore;
    }

    public Tile getLastTilePlayed()
    {
        return lastTilePlayed;
    }

    public void setLastTilePlayed(Tile newLastTilePlayed)
    {
        lastTilePlayed = newLastTilePlayed;
    }

    public Tile[] givePlayersTile()
    {
        Tile tempTiles[] = new Tile[5];
        tempTiles[0] = new Tile(1, 5);
        tempTiles[1] = new Tile(2, 4);
        tempTiles[2] = new Tile(3, 3);
        tempTiles[3] = new Tile(5, 2);
        tempTiles[4] = new Tile(7, 1);
        return tempTiles;
    }
}
