package IO;


import Core.players;
import Core.Connect4Logic;

import Core.PlayertagGenerator;

import java.util.Scanner;

/***
 * Handles the flow of the Connect 4 game by taking in user input and displays the game board after each player turn.
 *
 */
public class playerInfo extends Connect4Logic {

    private players Player1;
    private players Player2;
    private final PlayertagGenerator thisgenerate;

    /**
     *
     * Initialize all instance variables needed to handle class functionality.
     */
    public playerInfo() {
        this.thisgenerate = new PlayertagGenerator();



    }

    /***
     * Take in user input  and display the game board after each player turns.
     * Uses player information such as  position of play, and value being played.
     * allowing for proper game flow functionality.
     * @throws InterruptedException handle thread sleep to allow for each player to have adequate time to complete a move.
     */
    public void displayPlayInfo() throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        //take in player 1 name.
        System.out.print("Enter Player 1 name : ");
        String name = scan.nextLine();


     //generate random player tag for player 1.
       String tag1 = thisgenerate.generateRandomString();

        //take in player 2 name.
        System.out.print("Enter Player 2 name : ");
        String vname = scan.nextLine();

        //generate random player tag for player 2.
        String tag2 = thisgenerate.generateRandomString();

        //create player object.
        Player1 = new players(name,tag1,"X");
        Player2 = new players(vname, tag2, "O");

        //Print out player Information.
        System.out.println( " Welcome players : " + "\n" + "     Player 1 :  " + Player1.getName() +
                " Tag : "  + Player1.getPlayerTag() +  "\n" +
                  "      Player 2 : " + Player2.getName() +  " Tag : " + Player2.getPlayerTag());


        String value;
        String valuex;
        int Column;
        int Columnx;
        boolean tracker = true;
        while(tracker){

            //exit when game board is full resulting in a draw.
            if (isBoardFill()){
               Player1.displayUserInfo();
                System.out.println();
                Player2.displayUserInfo();
              System.out.println("Game is at a draw");
                tracker = false;
                break;

            }

            Thread.sleep(500);
            //take in player 1 value.
            System.out.println(Player1.getName() + " Enter " + Player1.getPlayermoveValue() + " value to make a play move: ");
            value = scan.nextLine();

            // Validate the input until it is correct.
            while (!value.equalsIgnoreCase(Player1.getPlayermoveValue())) {
                System.out.println(" Value must be '" + Player1.getPlayermoveValue() + "': ");
                value = scan.nextLine();
            }

            //take in player 1 position of play.
            Thread.sleep(500);
            System.out.println(" Enter Column (1 - 7) where you would like to input value: ");
            Column = scan.nextInt();

            // Handle the newline character after nextInt().
            scan.nextLine();

            //validate position of play and prompt the user to input correct value if it does not fall in to the expected range.
            while (Column < 1 || Column > 7) {
                System.out.println(" Column number must be between 1 and 7: ");
                Column = scan.nextInt();
                scan.nextLine();
            }

            Player1.setValue(value);
            Player1.setColumn(Column);

            insert(Player1.getColumn(), Player1.getValue());
            System.out.print(draw());


            if(getWincondition() == 0 ){
                System.out.println( " Winner ");
                Player1.displayUserInfo();
                tracker = false;
                break;
            }


            Thread.sleep(500);
            //take in player 1 value.
            System.out.println(Player2.getName() + " Enter " + Player2.getPlayermoveValue() + " value to make a play move: ");
            value = scan.nextLine();

            // Validate the input until it's correct.
            while (!value.equalsIgnoreCase(Player2.getPlayermoveValue())) {
                System.out.println(" Value must be '" + Player2.getPlayermoveValue() + "': ");
                value = scan.nextLine();
            }

            Thread.sleep(500);
            System.out.println(" Enter Column (1 - 7) where you would like to input value: ");
            Column = scan.nextInt();

            // Handle the newline character after nextInt().
            scan.nextLine();

            //validate position of play and prompt the user to input correct value if it does not fall in to the expected range.
            while (Column < 1 || Column > 7) {
                System.out.println("Column number must be between 1 and 7: ");
                Column = scan.nextInt();
                scan.nextLine();
            }

            Player2.setValue(value);
            Player2.setColumn(Column);

            insert(Player2.getColumn(), Player2.getValue());
            System.out.print(draw());

            if(getWincondition() == 1){
                System.out.println( " Winner ");
                Player2.displayUserInfo();
                tracker = false;
                break;
            }



        }
       scan.close();
    }
}
