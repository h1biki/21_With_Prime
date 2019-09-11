/**
 * class Player is the players include human and computer
 *
 * @author (Zixi Zhao)
 * @version (10-9-2019)
 */

public class Player
{
    private String name;
    private int score;
    private int roundsWon;
    private Tile tiles[];
    private Tile lastTilePlayed;
    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        score = 0;
        roundsWon = 0;
        tiles = new Tile[5];
    }

    /**
     * Non-default constructor for objects of class Player
     */
    public Player(String name, int score, int roundsWon, Tile tiles[])
    {
        this.name = name;
        this.score = score;
        this.roundsWon = roundsWon;
        this.tiles = tiles;
    }

    /**
     * Mutator of tiles
     *
     * @param  Tile newTiles[]
     * @return    void
     */
    public void setTiles(Tile newTiles[])
    {
        tiles = newTiles;
    }

    /**
     * Accessor of tiles
     *
     * @return    tiles
     */
    public Tile[] getTiles()
    {
        return tiles;
    }

    /**
     * Accessor of roundsWon
     *
     * @return    roundsWon
     */
    public int getRoundsWon()
    {
        return roundsWon;
    }

    /**
     * Mutator of roundsWon
     *
     * @param  int newRoundsWon
     * @return    void
     */
    public void setRoundsWon(int newRoundsWon)
    {
        roundsWon = newRoundsWon;
    }

    /**
     * Accessor of name
     *
     * @return    name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Mutator of name
     *
     * @param  String newName
     * @return    void
     */
    public void setName(String newName)
    {
        name = newName;
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
     * Accessor of lastTilePlayed
     *
     * @return    lastTilePlayed
     */
    public Tile getLastTilePlayed()
    {
        return lastTilePlayed;
    }

    /**
     * Mutator of lastTilePlayed
     *
     * @param  Tile newLastTilePlayed
     * @return    void
     */
    public void setLastTilePlayed(Tile newLastTilePlayed)
    {
        lastTilePlayed = newLastTilePlayed;
    }

    /**
     * To give players tiles which value is:[1,2,3,5,7] score is:[5,4,3,2,1]
     *
     * @return    void
     */
    public void givePlayersTile()
    {
        Tile tempTiles[] = new Tile[5];
        tempTiles[0] = new Tile(1, 5);
        tempTiles[1] = new Tile(2, 4);
        tempTiles[2] = new Tile(3, 3);
        tempTiles[3] = new Tile(5, 2);
        tempTiles[4] = new Tile(7, 1);
        tiles = tempTiles;
    }

    /**
     * Has two functions:
     *
     * Function 1: When a player played a tile, create a new tiles[]
     * which exclude this tile and replace the original tiles[].
     *
     *
     * Function 2: Return the tile which a player just played
     *
     * @param  int index
     * @return    tile
     */
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
        tiles = tempTiles;
        return tile;
    }

    /**
     *  To check whether a player have tile value equals 5 last at the finish of a round,
     *  if have then return true, if not, return false
     *
     * @return    boolean
     */
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
