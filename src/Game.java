import java.util.Scanner;

public class Game
{
    public void startGame()
    {
        Player player = new Player();
        Player computer = new Player();
        int gameTotal = 0;
        boolean isPlayerRegistered = false;
        displayMenu();
        System.out.println("Please Choose Your Option");
        Scanner scanner = new Scanner(System.in);//user starts to choose an option
        String option = scanner.nextLine();//option 1, 2, 3, 4
        if(option.equals("1"))
        {
            String playerNewName = giveNewName();
            player.setName(playerNewName);
            computer.setName("Computer");
            isPlayerRegistered = true;
        }
        else if(option.equals("2") && isPlayerRegistered == true)
        {
            playersPlaytile(player, computer, gameTotal);
        }
        else if(option.equals("3"))
        {
            help();
            startGame();
        }
        else if(option.equals("4"))
        {
            exit();
        }
        else
        {
            System.out.println("!!Invalid input, please input a valid option listed above!!");
            startGame();//validating input
        }
    }


    public void computerPlay(Player computer, int gameTotal)
    {
        int randomlyChoose = 0;
        do//computer choose a tile to play randomly
        {
            RNG random = new RNG();
            randomlyChoose = random.generateNumber(4);
          /*randomly generate int 1, 2, 3, 4, 5
          and perform an action to choose a tile from one of the five cards*/
        }while(computer.getTiles()[randomlyChoose].getValue() == computer.getLastTilePlayed().getValue());
        //verifying wheather the tile's value is same as the tile last played

        int tileChooseScore = computer.getTiles()[randomlyChoose].getScore();//choose from the tile[]
        int totalScore = tileChooseScore + computer.getScore();//score increment
        computer.setLastTilePlayed(computer.getTiles()[randomlyChoose]);//assign last tile played
        gameTotal = gameTotal + computer.getTiles()[randomlyChoose].getValue();//game total value increment
    }

    public void humanPlay(Player player, int gameTotal)
    {
        int chosenTileIndex = 0;

        do//function of human choose a tile to play
        {
            for(int i = 0; i < 5; i++)//list human obtained tiles
            {
                int value = player.getTiles()[i].getValue();
                int score = player.getTiles()[i].getScore();
                int orderNo = i + 1;
                System.out.println(orderNo + "---" + "Tile value:" + value + "Tile score:" + score);
            }
            System.out.println("Select your tile to play");
            Scanner scanner = new Scanner(System.in);//human choose a tile to play
            chosenTileIndex = scanner.nextInt();
        }while(player.getTiles()[chosenTileIndex - 1].getValue() == player.getLastTilePlayed().getValue());
        //verifying whether the tile's value same is as the tile last played

        int tileChosenScore = player.getTiles()[chosenTileIndex - 1].getScore();//choose from the tile[]
        int totalScore = tileChosenScore + player.getScore();//score increment
        player.setLastTilePlayed(player.getTiles()[chosenTileIndex - 1]);//assign last tile played
        gameTotal = gameTotal + player.getTiles()[chosenTileIndex - 1].getValue();//game total value increment
    }

    public String giveNewName()//option 1
    {
        System.out.println("Please input your name.");//show a message to input your name
        Scanner scanner = new Scanner(System.in);//user is typing....
        String userName = scanner.nextLine();
        while(userName.length() > 10 || userName.length() < 3)//validating the human input, when incorrect then ask to re-input the user's name
        {
            System.out.println("Your input is incorrect, please re-input the name.");
            userName = scanner.nextLine();
        }
        System.out.println("Gamer name assignment progress successfully finished.");
        System.out.println("Game will start shortly...");
        return userName;
    }

    public void playersPlaytile(Player player, Player computer,int gameTotal)//option 2
    {
        RNG rng = new RNG();
        int randomNumber = rng.generateNumber(5);//randomly choose the first one, randomly generate 0,1,2,3,4
        if(randomNumber > 2)
        {
            System.out.println(player.getName() + "is the first one who start the game");
            humanPlay(player, gameTotal);
            computerPlay(computer, gameTotal);//human start first
        }
        else
        {
            System.out.println(computer.getName() + "is the first one who start the game");
            computerPlay(computer, gameTotal);
            humanPlay(player, gameTotal);//computer start first
        }
    }

    public void help()//option 3
    {
        System.out.println("option 1 is used to register a new name for a new gamer");
        System.out.println("option 2 is used to start playing tiles between you and the computer");
        System.out.println("option 3 is used to display the help menu");
        System.out.println("option 4 is used to exit the game");
    }

    public void exit()//option 4
    {
        System.out.println("Game exited. Good Bye!");
    }

    public void displayMenu()
    {
        System.out.println("============================================");
        System.out.println("*    Welcome To The 21-With-Prime Game!    *");
        System.out.println("*                                          *");
        System.out.println("* Please select from the following options *");
        System.out.println("*     Press 1 to register a new player     *");
        System.out.println("*       Press 2 to start a new game        *");
        System.out.println("*        Press 3 to view help menu         *");
        System.out.println("*             Press 4 to exit              *");
        System.out.println("============================================");
    }
}
