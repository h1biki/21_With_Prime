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
        String option = scanner.nextLine().trim();//option 1, 2, 3, 4


        switch(option)
        {
            case "1":

                String humanName = nameAssign();
                player.setName(humanName);
                computer.setName("Computer");
                isPlayerRegistered = true;
                startGame();
                break;

            case "2":

                if(isPlayerRegistered = true)
                {
                    System.out.println("Please Enter The Round Number You Want To Play");
                    int round = scanner.nextInt();



                    while(round > 10 || round < 0)//validating the human input, when incorrect then ask to re-input round times
                    {
                        System.out.println("Please input a valid round number.");
                        round = scanner.nextInt();
                    }

                    for(int i = 0; i < round; i++)
                    {
                        playersPlaytile(player, computer, gameTotal);
                        judgeWinner(player, computer);
                    }
                }



                else
                {
                    System.out.println("Please enter your name before start the game...");
                    startGame();
                }
                break;
            case "3":

                help();
                startGame();
                break;

            case "4":

                System.out.println("Game exited. Good Bye!");
                break;

            default:

                System.out.println("!!Invalid input, please input a valid option listed above!!");
                startGame();
                break;
        }

    }

    public String nameAssign()//menu 1
    {
        System.out.println("Please input your name.");//show a message to input your name
        Scanner scanner = new Scanner(System.in);//user is typing....
        String userName = scanner.nextLine();
        while(userName.length() > 10 || userName.length() < 3)//validating the human input, when incorrect then ask to re-input the user's name
        {
            System.out.println("Your input is incorrect, please re-input the name.");
            userName = scanner.nextLine().trim();
        }
        System.out.println("Gamer name assignment progress successfully finished.");
        System.out.println("Game will start shortly...");
        return userName;
    }

    public void computerPlay(Player computer, int gameTotal)
    {
        int randomlyChoose = 0;
        computer.givePlayersTile();
        RNG random = new RNG();
        randomlyChoose = random.generateNumber(0,4);//randomly generate
        while(computer.getTiles()[randomlyChoose].getValue() != computer.getLastTilePlayed().getValue())//verifying whether the tile's value is same as the tile last played
        {
            randomlyChoose = random.generateNumber(0,4);//randomly generate
        }
        int tileChooseValue = computer.getTiles()[randomlyChoose].getValue();
        int tileChosenScore = computer.getTiles()[randomlyChoose].getScore();
        computer.setScore(computer.getTiles()[randomlyChoose].getScore());
        int totalScore = tileChosenScore + computer.getScore();//score increment
        computer.setLastTilePlayed(computer.getTiles()[randomlyChoose]);//assign last tile played
        gameTotal = gameTotal + tileChooseValue;//game total value increment

        System.out.println("Computer plays tile " + computer.getLastTilePlayed().getValue() + ". Game total is now " + gameTotal +
                ". Computer score is " + totalScore + ".");
    }

    public void humanPlay(Player player, int gameTotal)
    {
        int chosenTileIndex = 0;
        player.givePlayersTile();
        for(int i = 0; i < 5; i++)//list human obtained tiles
        {
            int value = player.getTiles()[i].getValue();
            int score = player.getTiles()[i].getScore();
            int order = i + 1;
            System.out.println(order + "---" + "Tile value:" + value + "Tile score:" + score);
        }
        System.out.println("Select your tile to play");
        Scanner scanner = new Scanner(System.in);//human choose a tile to play
        chosenTileIndex = scanner.nextInt();

        int tileChosenScore = player.getTiles()[chosenTileIndex - 1].getScore();//choose from the tile[]
        int tileChooseValue = player.getTiles()[chosenTileIndex - 1].getValue();
        player.setScore(player.getTiles()[chosenTileIndex - 1].getScore());
        int totalScore = tileChosenScore + player.getScore();//score increment
        player.setLastTilePlayed(player.getTiles()[chosenTileIndex - 1]);//assign last tile played
        gameTotal = gameTotal + player.getTiles()[chosenTileIndex - 1].getValue();//game total value increment

        System.out.println(player.getName() + " plays tile " + player.getLastTilePlayed().getValue() + ". Game total is now " + gameTotal +
                "." + player.getName() + " score is " + totalScore + ".");
    }

    public void playersPlaytile(Player player, Player computer,int gameTotal)//menu 2
    {
        RNG rng = new RNG();
        int randomNumber = rng.generateNumber(0,4);//randomly choose the first one 01234



        if(randomNumber > 2)
        {
            System.out.println(player.getName() + "is the first one who start the game");
            do
            {
                humanPlay(player, gameTotal);
                computerPlay(computer, gameTotal);//human start first
            }while(gameTotal <= 21);
        }else
        {
            System.out.println(computer.getName() + "is the first one who start the game");
            do
            {
                computerPlay(computer, gameTotal);
                humanPlay(player, gameTotal);//computer start first
            }while(gameTotal <= 21);
        }





    }

    public void help()//menu 3
    {
        System.out.println("option 1 is used to register a new name for a new gamer");
        System.out.println("option 2 is used to start playing tiles between you and the computer");
        System.out.println("option 3 is used to display the help menu");
        System.out.println("option 4 is used to exit the game");
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

    /*public void hasFive()
    {
        totalScore = totalScore - 3;
    }

    public void winnerBonus()
    {
        totalScore = totalScore + 5;
    }
    */

    public void judgeWinner(Player player, Player computer)
    {
        if (player.getRoundsWon() < computer.getRoundsWon())
        {
            System.out.println("Game over! Computer win! better next time...");
        }else if(player.getRoundsWon() > computer.getRoundsWon())
        {
            System.out.println("Congratulations! you win!!");
        }else
        {
            System.out.println("OMG is a tie!!!");
        }
    }

    /*public int getTotalScore()
    {
        return totalScore;
    }*/
}
/*WIP: int totalScore,
round times
and win-lose rules and score rules*/