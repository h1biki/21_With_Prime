/**
 * class Player is the players include human and computer
 *
 * @author (Zixi Zhao)
 * @version (14-9-2019)
 */
public class Player
{
    private String name;//a player's name
    private int score;//a player's round score
    private int roundsWon;//a player's won round times
    private Tile tiles[];//array for keeping player's tiles
    private Tile lastTilePlayed;//the tile which a player just played

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
     * Accessor of lastTilePlayed
     *
     * @return    lastTilePlayed
     */
    public Tile getLastTilePlayed()
    {
        return lastTilePlayed;
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
     * Accessor of roundsWon
     *
     * @return    roundsWon
     */
    public int getRoundsWon()
    {
        return roundsWon;
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
     * Accessor of tiles
     *
     * @return    tiles
     */
    public Tile[] getTiles()
    {
        return tiles;
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
     *  To check whether a player have tile value equals 5 last at the finish of a round,
     *  if have then return true, if not, return false
     *
     * @return    boolean
     */
    public boolean hasFive()
    {
        for (int i = 0; i < tiles.length; i++)
        {
            if (tiles[i].getValue() == 5)//traversing tiles[], if found tile's value is 5 then return true
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Mutator of lastTilePlayed
     *
     * @param  newLastTilePlayed    the new value of lastTilePlayed
     * @return    void
     */
    public void setLastTilePlayed(Tile newLastTilePlayed)
    {
        lastTilePlayed = newLastTilePlayed;
    }

    /**
     * Mutator of name
     *
     * @param  newName  the new value of name
     * @return    void
     */
    public void setName(String newName)
    {
        name = newName;
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
     * When a player played a tile, create a new array
     * which exclude this tile and replace the original tiles[].
     *
     * @param  index   A element's index in tiles[]
     * @return    the tile a player just played
     */
    public void tileArrayReplacement(int index)
    {
        Tile tile = tiles[index];//get the tile just played
        Tile tempTiles[] = new Tile[tiles.length - 1];//create new array, ready for insert tiles haven't be used
        int j = 0;
        for (int i = 0; i < tiles.length; i++)//traversing original tiles[]
        {
            if (i != index)
            {
                tempTiles[j++] = tiles[i];//insert the tiles haven't be used to the new array
            }
        }
        tiles = tempTiles;
    }
}
