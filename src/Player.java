
public class Player
{
    private String name;
    private int score;
    private int roundsWon;
    private Tile tiles[];
    private Tile lastTilePlayed;

    // private int totalScore;
    public Player()
    {
        name = "";
        score = 0;
        roundsWon = 0;
        tiles = new Tile[5];
        // totalScore = 0;
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

    public void givePlayersTile()
    {
        Tile tempTiles[] = new Tile[5];
        tempTiles[0] = new Tile(1, 5);
        tempTiles[1] = new Tile(2, 4);
        tempTiles[2] = new Tile(3, 3);
        tempTiles[3] = new Tile(5, 2);
        tempTiles[4] = new Tile(7, 1);
        this.tiles = tempTiles;
    }

    public Tile getTile(int index)
    {
        if (index >= tiles.length)
        {
            return null;
        }
        Tile tile = tiles[index];
        Tile tempTiles[] = new Tile[tiles.length - 1];
        int j = 0;
        for (int i = 0; i < tiles.length; i++)
        {
            if (i != index)
            {
                tempTiles[j++] = tiles[i];
            }
        }
        this.tiles = tempTiles;
        return tile;
    }

    public boolean hasFive()
    {
        for (int i = 0; i < tiles.length; i++)
        {
            if (tiles[i].getValue() == 5)
            {
                return true;
            }
        }
        return false;
    }
}
