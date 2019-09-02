

public class Player
{
    private String name;
    private int score;
    private int roundsWon;
    private Tile tiles[];
    private Tile lastTilePlayed;

    public Player()
    {
        name = "";
        score = 0;
        roundsWon = 0;
        tiles = new Tile[5];
        lastTilePlayed = new Tile();
    }

    public Player(String newName, int newScore, Tile[] newTiles, Tile newLastTilePlayed, int newRoundsWon)
    {
        name = newName;
        score = newScore;
        tiles = newTiles;
        lastTilePlayed = newLastTilePlayed;
        roundsWon = newRoundsWon;
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

    public void setTiles(Tile[] newTiles)
    {
        tiles = newTiles;
    }

    public Tile[] getTiles()
    {
        return tiles;
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

    public Tile getLastTilePlayed()
    {
        return lastTilePlayed;
    }

    public void setLastTilePlayed(Tile newLastTilePlayed)
    {
        lastTilePlayed = newLastTilePlayed;
    }
}
